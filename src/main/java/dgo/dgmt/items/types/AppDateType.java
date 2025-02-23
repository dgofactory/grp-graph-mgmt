package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.DateDeserializer;
import dgo.dgmt.items.types.json.SingleValueSerializer;

import java.time.OffsetDateTime;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = DateDeserializer.class)
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
