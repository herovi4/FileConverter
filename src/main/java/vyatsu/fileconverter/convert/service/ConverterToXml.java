package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.FileUtils;
import vyatsu.fileconverter.converters.JsonToXmlConverter;

import java.io.IOException;

public class ConverterToXml implements Converter {
    @Override
    public void convert(final String inputFileName, final String outputFileName) throws IOException {
        FileUtils.writeXmlFile(JsonToXmlConverter.convertToXml(
                FileUtils.readFromJson(inputFileName)),outputFileName);
    }
}
