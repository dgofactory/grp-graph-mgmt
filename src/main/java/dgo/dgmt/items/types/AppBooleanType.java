package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BooleanType extends AbstractType<BooleanType> {

    private boolean rawValue;

    public BooleanType(ObjectMapper objectMapper, boolean rawValue) {
        super(objectMapper);
    }

    @Override
    AppType appType() {
        return AppType.BOOLEAN;
    }

    @Override
    String stringRepresentation() {
        return String.valueOf(rawValue);
    }

    @Override
    JsonNode jsonRepresentation() {
        return singleValueJsonRepresentation(String.valueOf(rawValue));
    }

    @Override
    BooleanType emptyValue() {
        return null;
    }
}
