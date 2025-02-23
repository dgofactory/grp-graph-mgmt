package dgo.dgmt.items.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dgo.dgmt.items.types.json.MoneyValueDeserializer;
import dgo.dgmt.items.types.json.SingleValueSerializer;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = MoneyValueDeserializer.class)
public class AppMoneyType implements AbstractType<MoneyValue>{

    @JsonProperty
    private final MoneyValue value;

    public AppMoneyType(Double rawValue, String code) {
        this.value = MoneyValue.builder()
                .value(rawValue)
                .code(code)
                .build();
    }

    @Override
    public AppType appType() {
        return AppType.MONETARY;
    }

    @Override
    public MoneyValue rawValue() {
        return this.value;
    }
}
