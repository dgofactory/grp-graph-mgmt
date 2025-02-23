package dgo.dgmt.items.types;


import com.fasterxml.jackson.core.JsonProcessingException;
import dgo.dgmt.items.types.json.TypesHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TypesTests {

    @Test
    void testDefaultValueAppStringType() {
        AppStringType result = AppTypesFactoryDefault.defaultValue(AppType.STRING);
        assertEquals("\"\"", TypesHelper.writeAsString(result));
    }

    @Test
    void testDefaultValueAppBooleanType() {
        AppBooleanType result = AppTypesFactoryDefault.defaultValue(AppType.BOOLEAN);
        assertEquals("false", TypesHelper.writeAsString(result));
    }

    @Test
    void testDefaultValueAppMoneyType() {
        AppMoneyType result = AppTypesFactoryDefault.defaultValue(AppType.MONETARY);
        assertEquals("""
                                {"value":0.0,"code":"MXN"}
                     """.trim(), TypesHelper.writeAsString(result).trim());
    }

    @Test
    void testDefaultValueNumberType() {
        AppNumberType result = AppTypesFactoryDefault.defaultValue(AppType.NUMBER);
        assertEquals("0", TypesHelper.writeAsString(result));
    }
    //generate test for AppDateTimeType
    @Test
    void testDefaultValueAppDateTimeType() {
        AppDateTimeType result = AppTypesFactoryDefault.defaultValue(AppType.LONG_DATE);
        var date = result.rawValue();
        String now;
        try {
            now = TypesHelper.getObjectMapper().writeValueAsString(date);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        assertEquals(now, TypesHelper.writeAsString(result));
    }

    @Test
    void testDefaultValueAppDateType() {
        AppDateType result = AppTypesFactoryDefault.defaultValue(AppType.SHORT_DATE);
        var date = result.rawValue();
        String now;
        try {
            now = TypesHelper.getObjectMapper().writeValueAsString(date);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        assertEquals(now, TypesHelper.writeAsString(result));
    }

    @Test
    void testDefaultValueAppTimeType() {
        AppTimeType result = AppTypesFactoryDefault.defaultValue(AppType.TIME);
        var date = result.rawValue();
        String now;
        try {
            now = TypesHelper.getObjectMapper().writeValueAsString(date);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        assertEquals(now, TypesHelper.writeAsString(result));
    }

    @Test
    void testDefaultValueAppPhoneType() {
        AppPhoneType result = AppTypesFactoryDefault.defaultValue(AppType.PHONE);
        assertEquals("""
                                {"number":0,"extension":0,"country":52,"area":55}
                     """.trim(), TypesHelper.writeAsString(result).trim());
    }

    @Test
    void testDefaultValueAppMoneyTypeDes() {
        AppMoneyType result = AppTypesFactoryDefault.defaultValue(AppType.MONETARY);
        Optional<AppMoneyType> moneyType = TypesHelper.readFromString(AppMoneyType.class, TypesHelper.writeAsString(result));
        assertTrue(moneyType.isPresent());
        assertEquals(result.rawValue(), moneyType.get().rawValue());
    }

    @Test
    void testDefaultValueAppPhoneTypeDes() {
        AppPhoneType result = AppTypesFactoryDefault.defaultValue(AppType.PHONE);
        Optional<AppPhoneType> phoneType = TypesHelper.readFromString(AppPhoneType.class, TypesHelper.writeAsString(result));
        assertTrue(phoneType.isPresent());
        assertEquals(result.rawValue(), phoneType.get().rawValue());
    }

    @Test
    void testDefaultValueAppDateTimeTypeDes() {
        AppDateTimeType result = AppTypesFactoryDefault.defaultValue(AppType.LONG_DATE);
        Optional<AppDateTimeType> dateTimeType = TypesHelper.readFromString(AppDateTimeType.class, TypesHelper.writeAsString(result));
        assertTrue(dateTimeType.isPresent());
        assertTrue(result.rawValue().isEqual(dateTimeType.get().rawValue()));
    }


}
