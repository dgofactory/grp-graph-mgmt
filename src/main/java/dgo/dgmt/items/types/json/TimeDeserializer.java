package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import dgo.dgmt.items.types.AbstractType;
import dgo.dgmt.items.types.AppTimeType;

import java.io.IOException;
import java.time.OffsetTime;

public class TimeDeserializer extends SingleValueDeserializer<OffsetTime>{

    @Override
    protected AbstractType<OffsetTime> createInstance(JsonParser p) throws IOException, JacksonException {
        return new AppTimeType(p.readValueAs(OffsetTime.class));
    }
}
