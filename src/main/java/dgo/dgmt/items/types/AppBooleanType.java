package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SingleValueSerializer.class)
public class AppBooleanType implements AbstractType<Boolean>{

    private final boolean value;

    public AppBooleanType(boolean rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.BOOLEAN;
    }

    @Override
    public Boolean rawValue() {
        return value;
    }
}
