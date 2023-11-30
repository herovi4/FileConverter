package vyatsu.fileconverter.convert.service;

import lombok.experimental.FieldDefaults;
import vyatsu.fileconverter.ReaderFromFile;
import vyatsu.fileconverter.WriterToFile;
import vyatsu.fileconverter.converters.JsonToXmlConverter;
@FieldDefaults(makeFinal = true)
class ConverterToXml implements Converter {
    @Override
    public void getConverter(final String inputFileName, final String outputFileName) {
        WriterToFile.writeXmlFile(JsonToXmlConverter.convertToXml(ReaderFromFile.readFromJson(inputFileName)),outputFileName);
    }
}
