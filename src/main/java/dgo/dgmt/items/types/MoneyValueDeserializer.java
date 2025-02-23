package dgo.dgmt.items.types;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class RawTypeValueDeserializer extends JsonDeserializer<AbstractType<?>> {
    @Override
    public AbstractType<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        //deserilize from MoneValue

        return null;
    }
}
