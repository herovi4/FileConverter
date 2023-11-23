package vyatsu.fileconverter;

public enum Type {
    XML_TO_JSON, JSON_TO_XML;

    public static Type byInt(final int choice) {
        return switch (choice) {
            case 1 -> XML_TO_JSON;
            case 2 -> JSON_TO_XML;
            default -> throw new IllegalStateException();
        };
    }
}
