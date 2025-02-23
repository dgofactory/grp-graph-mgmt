package dgo.dgmt.items.types;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.SingleValueSerializer;

@JsonSerialize(using = SingleValueSerializer.class)
public class AppStringType implements AbstractType<String>{
    private final String value;

    public AppStringType(String rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.STRING;
    }

    @Override
    public String rawValue() {
        return value;
    }
}
