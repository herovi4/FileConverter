package vyatsu.fileconverter.convert.service;

import lombok.experimental.FieldDefaults;
import vyatsu.fileconverter.ReaderFromFile;
import vyatsu.fileconverter.WriterToFile;
import vyatsu.fileconverter.converters.XMLToJsonConverter;

import java.io.IOException;
@FieldDefaults(makeFinal = true)
class ConverterToJson implements Converter {
    @Override
    public void getConverter(final String inputFileName, final String outputFileName) {
        WriterToFile.writeJsonFile(XMLToJsonConverter.convertToJson(ReaderFromFile.readFromXML(inputFileName)),outputFileName);
    }
}
