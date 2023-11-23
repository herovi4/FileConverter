package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.ReaderFromFile;
import vyatsu.fileconverter.XmlStructure.NBAPlayers;
import vyatsu.fileconverter.converters.XMLToJsonConverter;

import java.io.IOException;

class XmlToJsonConverter implements Convert {
    @Override
    public void convert(final String inputFileName, final String outputFileName) throws IOException {
        NBAPlayers playersXML = ReaderFromFile.readFromXML(inputFileName);
        XMLToJsonConverter.transform(playersXML, outputFileName);
    }
}
