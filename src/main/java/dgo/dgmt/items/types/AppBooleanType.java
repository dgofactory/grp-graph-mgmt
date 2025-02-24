package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.BooleanDeserializer;
import dgo.dgmt.items.types.json.SingleValueSerializer;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = BooleanDeserializer.class)
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
