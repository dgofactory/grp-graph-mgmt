package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import dgo.dgmt.items.types.AbstractType;
import dgo.dgmt.items.types.AppNumberType;

import java.io.IOException;

public class NumberDeserializer  extends SingleValueDeserializer<Long>{

    @Override
    protected AbstractType<Long> createInstance(JsonParser p) throws IOException, JacksonException {
        return new AppNumberType(p.readValueAs(Long.class));
    }
}
