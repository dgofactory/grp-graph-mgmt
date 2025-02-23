package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import dgo.dgmt.items.types.AbstractType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SingleValueSerializer extends JsonSerializer<AbstractType<?>> {
    @Override
    public void serialize(AbstractType<?> value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        log.debug("Serializing value: {}", value);
        gen.writeObject(value.rawValue());
    }
}