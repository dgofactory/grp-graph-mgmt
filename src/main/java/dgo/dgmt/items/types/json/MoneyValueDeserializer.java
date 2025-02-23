package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import dgo.dgmt.items.types.AppMoneyType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MoneyValueDeserializer extends JsonDeserializer<AppMoneyType> {
    @Override
    public AppMoneyType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        log.debug("Single Value Deserializing MoneyValue..");
        var node = deserializationContext.readTree(jsonParser);
        var value = node.get("value").asDouble();
        var code = node.get("code").asText();
        return  new AppMoneyType(value, code);
    }
}
