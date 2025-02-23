package dgo.dgmt.items.types;

public enum EnumTypes {
    STRING("string"),
    NUMBER("integer"),
    BOOLEAN("boolean"),
    COMPOSE("object"),
    MONETARY("monetary"),
    PHONE("phone"),
    SHORT_DATE("short_date"),
    LONG_DATE("long_date"),
    NULL("null");

    private final String type;

    EnumTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
