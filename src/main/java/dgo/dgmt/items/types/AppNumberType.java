package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.NumberDeserializer;
import dgo.dgmt.items.types.json.SingleValueSerializer;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = NumberDeserializer.class)
public class AppNumberType implements AbstractType<Long>{

    private final Long value;

    public AppNumberType(Long rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.NUMBER;
    }

    @Override
    public Long rawValue() {
        return value;
    }
}
