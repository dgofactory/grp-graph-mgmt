package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import dgo.dgmt.items.types.AbstractType;
import dgo.dgmt.items.types.AppDateTimeType;

import java.io.IOException;
import java.time.OffsetDateTime;

public class DateTimeDeserializer extends SingleValueDeserializer<OffsetDateTime> {
    @Override
    protected AbstractType<OffsetDateTime> createInstance(JsonParser p) throws IOException, JacksonException {
        return  new AppDateTimeType(p.readValuesAs(OffsetDateTime.class).next());
    }
}
