package vyatsu.fileconverter.convert.service;

import vyatsu.fileconverter.FileUtils;
import vyatsu.fileconverter.converters.XMLToJsonConverter;

class ConverterToJson implements Converter {
    @Override
    public void convert(final String inputFileName, final String outputFileName) {
        FileUtils.writeJsonFile(XMLToJsonConverter.convertToJson(FileUtils.readFromXML(inputFileName)),outputFileName);
    }
}
