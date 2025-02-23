package dgo.dgmt.items.types;

public class MoneyFactoryDefault {

    @SuppressWarnings("unchecked")
    public static <T extends AbstractType<?>> T defaultValue(AppType appType) {
        return switch (appType) {
            case STRING -> (T) new AppStringType("");
            case BOOLEAN -> (T)  new AppBooleanType(false);
            case MONETARY -> (T)  new AppMoneyType(0.0);
            default -> throw new IllegalArgumentException("Unknown type: " + appType);
        };
    }
}
