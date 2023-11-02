package converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

        JsonObject clubs = new JsonObject();

        for (Player player : players.getPlayers()) {
            String teamName = player.getTeamName();

            if (!clubs.has(teamName)) {
                clubs.add(teamName, new JsonArray());
            }

            JsonObject playerJson = gson.toJsonTree(player).getAsJsonObject();
            clubs.getAsJsonArray(teamName).add(playerJson);
        }

        JsonArray clubsArray = new JsonArray();
        clubsArray.add(clubs);

        JsonObject nbaPlayers = new JsonObject();
        nbaPlayers.add("clubs", clubsArray);

        // Записываем JSON в файл
        String jsonOutput = gson.toJson(nbaPlayers);
        File jsonFile = new File("players.json");
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(jsonOutput);
        writer.close();
    }



}
