package dgo.dgmt.items.types;

public enum AppType {
    STRING("string"),
    NUMBER("integer"),
    BOOLEAN("boolean"),
    COMPOSE("object"),
    MONETARY("monetary"),
    PHONE("phone"),
    SHORT_DATE("short_date"),
    LONG_DATE("long_date"),
    TIME("time");

    private final String type;

    AppType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
