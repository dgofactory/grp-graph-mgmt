package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import dgo.dgmt.items.types.AppPhoneType;
import dgo.dgmt.items.types.PhoneValue;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class PhoneValueDeserializer extends JsonDeserializer<AppPhoneType> {
    @Override
    public AppPhoneType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        log.debug("Deserializing PhoneValue..");
        var phoneValue = jsonParser.readValueAs(PhoneValue.class);
        return new AppPhoneType(phoneValue);
    }
}
