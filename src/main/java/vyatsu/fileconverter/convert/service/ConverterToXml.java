package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.FileUtils;
import vyatsu.fileconverter.converters.JsonToXmlConverter;
class ConverterToXml implements Converter {
    @Override
    public void convert(final String inputFileName, final String outputFileName) {
        FileUtils.writeXmlFile(JsonToXmlConverter.convertToXml(FileUtils.readFromJson(inputFileName)),outputFileName);
    }
}
