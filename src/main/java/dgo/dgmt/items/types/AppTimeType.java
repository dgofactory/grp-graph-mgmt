package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.OffsetTime;

@JsonSerialize(using = SingleValueSerializer.class)
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
