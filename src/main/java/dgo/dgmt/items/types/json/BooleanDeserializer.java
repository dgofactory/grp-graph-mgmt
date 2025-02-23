package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import dgo.dgmt.items.types.AbstractType;
import dgo.dgmt.items.types.AppBooleanType;

import java.io.IOException;

public class BooleanDeserializer extends SingleValueDeserializer<Boolean>{
    @Override
    protected AbstractType<Boolean> createInstance(JsonParser p) throws IOException, JacksonException {
        return new AppBooleanType(p.readValueAs(Boolean.class));
    }
}
