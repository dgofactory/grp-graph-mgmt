package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.OffsetDateTime;

@JsonSerialize(using = SingleValueSerializer.class)
public class AppDateType implements AbstractType<OffsetDateTime>{
    private final OffsetDateTime value;

    public AppDateType(OffsetDateTime rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.SHORT_DATE;
    }

    @Override
    public OffsetDateTime rawValue() {
        return value;
    }
}
