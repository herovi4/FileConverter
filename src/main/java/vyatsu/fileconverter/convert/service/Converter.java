package vyatsu.fileconverter.convert.service;

import java.io.IOException;

public interface Converter {
    void convert(final String inputFileName, final String outputFileName) throws IOException;
}





