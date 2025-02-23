package dgo.dgmt.items.types;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class AppTypesFactoryDefault {

    @SuppressWarnings("unchecked")
    public static <T extends AbstractType<?>> T defaultValue(AppType appType) {
        return switch (appType) {
            case STRING -> (T) new AppStringType("");
            case BOOLEAN -> (T)  new AppBooleanType(false);
            case NUMBER -> (T)  new AppNumberType(0L);
            case LONG_DATE -> (T)  new AppDateTimeType(OffsetDateTime.now());
            case SHORT_DATE -> (T)  new AppDateType(OffsetDateTime.now());
            case TIME -> (T)  new AppTimeType(OffsetTime.now());
            case MONETARY -> (T)  new AppMoneyType(0.0, "MXN");
            case PHONE -> (T)  new AppPhoneType(52, 55, 0);


            default -> throw new IllegalArgumentException("Unknown type: " + appType);
        };
    }
}
