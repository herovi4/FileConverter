package converters;

import com.google.gson.*;
import structure.Player;
import structure.NBAPlayers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLToJsonConverter {
    public static void transform(NBAPlayers players) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .create();

        JsonObject teams = new JsonObject();
        JsonArray teamArray = new JsonArray();

        for (Player player : players.getPlayers()) {
            String teamName = player.getTeamName();

            JsonObject playerJson = gson.toJsonTree(player).getAsJsonObject();

            boolean teamExists = false;
            for (JsonElement teamElement : teamArray) {
                JsonObject teamObject = teamElement.getAsJsonObject();
                JsonObject team = teamObject.get("team").getAsJsonObject();

                if (team.get("name").getAsString().equals(teamName)) {
                    JsonArray playersArray = team.get("players").getAsJsonArray();
                    playersArray.add(playerJson);
                    teamExists = true;
                    break;
                }
            }

            if (!teamExists) {
                JsonObject teamObject = new JsonObject();
                JsonObject team = new JsonObject();
                team.addProperty("name", teamName);
                JsonArray playersArray = new JsonArray();
                playersArray.add(playerJson);
                team.add("players", playersArray);
                teamObject.add("team", team);
                teamArray.add(teamObject);
            }
        }

        teams.add("teams", teamArray);

        // Записываем JSON в файл
        String jsonOutput = gson.toJson(teams);
        File jsonFile = new File("players.json");
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(jsonOutput);
        writer.close();
    }

}
