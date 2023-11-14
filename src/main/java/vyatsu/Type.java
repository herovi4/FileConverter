package vyatsu;

public enum Type {
    XML_TO_JSON, JSON_TO_XML, INCORRECT;
    public static Type byInt(int choice)
    {
        return switch (choice)
        {
            case 1 -> XML_TO_JSON;
            case 2 -> JSON_TO_XML;
            default -> INCORRECT;
        };
    }
}
