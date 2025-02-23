package dgo.dgmt.items.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SingleValueSerializer.class)
@JsonDeserialize(using = PhoneValueDeserializer.class)
public class AppPhoneType implements AbstractType<PhoneValue> {

    private final PhoneValue value;

    public AppPhoneType(int country, int area, int number) {
        this.value = PhoneValue.builder()
                .countryCode(country)
                .areaArea(area)
                .number(number
                ).build();
    }

    public AppPhoneType(int country, int area, int number, int extension, String type) {
        this.value = PhoneValue.builder()
                .countryCode(country)
                .areaArea(area)
                .number(number)
                .extension(extension)
                .type(type).build();
    }

    public AppPhoneType(PhoneValue phoneValue){
        this.value = phoneValue;
    }

    @Override
    public AppType appType() {
        return AppType.PHONE;
    }

    @Override
    public PhoneValue rawValue() {
        return value;
    }
}
