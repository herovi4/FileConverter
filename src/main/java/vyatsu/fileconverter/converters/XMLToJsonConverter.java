package vyatsu.fileconverter.converters;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.experimental.UtilityClass;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.JsonStructure.Teams;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.Player;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@UtilityClass
public class XMLToJsonConverter {
    Gson gson = new Gson();

    private List<Teams> convertJsonArrayToList(JsonArray jsonArray) {
        Type teamsListType = new TypeToken<List<Teams>>() {
        }.getType();

        return gson.fromJson(jsonArray, teamsListType);
    }

    public NBAPlayersJson convertToJson(final NBAPlayers players) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .create();

        JsonArray teamArray = StreamSupport.stream(players.getPlayers().spliterator(), false)
                .collect(Collectors.groupingBy(Player::getTeamName, LinkedHashMap::new,Collectors.toList()))
                .entrySet()
                .stream()
                .map(entry -> {
                    JsonObject teamObject = new JsonObject();
                    JsonObject team = new JsonObject();
                    team.addProperty("name", entry.getKey());
                    JsonArray playersArray = entry.getValue().stream()
                            .map(player -> gson.toJsonTree(player).getAsJsonObject())
                            .collect(JsonArray::new, JsonArray::add, JsonArray::addAll);
                    team.add("players", playersArray);
                    teamObject.add("team", team);
                    return teamObject;
                })
                .collect(JsonArray::new, JsonArray::add, JsonArray::addAll);

        JsonObject teams = new JsonObject();
        teams.add("teams", teamArray);

        return new NBAPlayersJson(convertJsonArrayToList(teamArray));
    }
}
