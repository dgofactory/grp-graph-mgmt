package dgo.dgmt.items.types.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dgo.dgmt.items.types.AbstractType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class TypesHelper {
    private static final ThreadLocal<ObjectMapper> objectMapper = ThreadLocal.withInitial(() -> {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);

        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        return objectMapper;
    });


    public static  ObjectMapper getObjectMapper() {
        return objectMapper.get();
    }

    @NonNull
    public static <T extends AbstractType<?>> String writeAsString(T object) {
        try {
            return objectMapper.get().writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error converting object to JSON", e);
            return "";
        }
    }

    public static <T extends AbstractType<?>> Optional<T> readFromString(Class<T> clazz, String value) {
        try {
            var o =  objectMapper.get().readValue(value, clazz);
            return Optional.of(o);
        } catch (Exception e) {
            log.error("Error converting object to JSON", e);
            return Optional.empty();
        }
    }

}
