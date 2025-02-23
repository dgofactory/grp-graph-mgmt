package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import dgo.dgmt.items.types.AbstractType;
import dgo.dgmt.items.types.AppStringType;

import java.io.IOException;

public class StringDeserializer extends SingleValueDeserializer<String>{

    @Override
    protected AbstractType<String> createInstance(JsonParser p) throws IOException, JacksonException {
        return new AppStringType(p.readValueAs(String.class));
    }
}
