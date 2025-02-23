package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import dgo.dgmt.items.types.AbstractType;

import java.io.IOException;

public abstract class SingleValueDeserializer<T> extends JsonDeserializer<AbstractType<T>> {

    @Override
    final public AbstractType<T> deserialize(JsonParser p, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        return createInstance(p);
    }
    abstract protected AbstractType<T> createInstance(JsonParser p) throws IOException, JacksonException;
}
