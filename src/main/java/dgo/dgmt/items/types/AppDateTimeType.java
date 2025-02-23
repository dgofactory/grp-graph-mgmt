package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.DateTimeDeserializer;
import dgo.dgmt.items.types.json.SingleValueSerializer;

import java.time.OffsetDateTime;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = DateTimeDeserializer.class)
public class AppDateTimeType implements AbstractType<OffsetDateTime>{
    private final OffsetDateTime value;

    public AppDateTimeType(OffsetDateTime rawValue) {
        this.value = rawValue;
    }

    @Override
    public AppType appType() {
        return AppType.LONG_DATE;
    }

    @Override
    public OffsetDateTime rawValue() {
        return value;
    }
}
