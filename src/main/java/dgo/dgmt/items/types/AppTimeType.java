package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.SingleValueSerializer;
import dgo.dgmt.items.types.json.TimeDeserializer;

import java.time.OffsetTime;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = TimeDeserializer.class)
public class AppTimeType implements AbstractType<OffsetTime>{

    private final OffsetTime value;

    public AppTimeType(OffsetTime rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.TIME;
    }

    @Override
    public OffsetTime rawValue() {
        return value;
    }
}
