package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.FileUtils;
import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.XmlStructure.PlayerXML;
import vyatsu.fileconverter.XmlStructure.Statistics;

import java.io.IOException;

public class ConverterToXml implements Converter {
    @Override
    public void convert(final String inputFileName, final String outputFileName) throws IOException {
        FileUtils.writeXmlFile(convertToXml(
            FileUtils.readFromJson(inputFileName)), outputFileName);
    }
    public static NBAPlayers convertToXml(final NBAPlayersJson nbaPlayersJson) {
        return NBAPlayers.builder()
            .players(nbaPlayersJson.getTeams().stream()
                .flatMap(team -> team.getTeam().players().stream()
                    .map(playerJson -> PlayerXML.builder()
                        .name(playerJson.name())
                        .position(playerJson.position())
                        .jerseyNumber(playerJson.jerseyNumber())
                        .teamName(team.getTeam().teamName())
                        .statistic(new Statistics(
                            playerJson.statistic().pointsPerGame(),
                            playerJson.statistic().assistsPerGame(),
                            playerJson.statistic().reboundsPerGame()))
                        .build()))
                .toList())
            .build();
    }
}
