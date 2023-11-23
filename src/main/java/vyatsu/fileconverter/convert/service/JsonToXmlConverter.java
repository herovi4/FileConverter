package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.JsonStructure.NBAPlayersJson;
import vyatsu.fileconverter.ReaderFromFile;

class JsonToXmlConverter implements Convert {
    @Override
    public void convert(final String inputFileName, final String outputFileName) {
        NBAPlayersJson nbaPlayersJson = ReaderFromFile.readFromJson(inputFileName);
        vyatsu.fileconverter.converters.JsonToXmlConverter.convertToXml(nbaPlayersJson, outputFileName);
    }
}
