package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SingleValueSerializer.class)
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
