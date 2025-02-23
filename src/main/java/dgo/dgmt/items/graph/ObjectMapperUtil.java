package dgo.dgmt.items.graph;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ObjectMapperUtil {
    private static final ThreadLocal<ObjectMapper> objectMapper = ThreadLocal.withInitial(() -> {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);
        objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        return objectMapper;
    });

    public <T> T readFromString(String jsonString, Class<T> clazz) {
        if (jsonString == null) {
            return null;
        }
        try {
            return (T) objectMapper.get().readValue(jsonString, clazz);
        } catch (Exception e) {
            log.error("Error converting JSON value", e);
            return null;
        }
    }
    public ObjectMapper getObjectMapper() {
        return objectMapper.get();
    }

    public String writeAsString(Object object) {
        try {
            return objectMapper.get().writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error converting object to JSON", e);
            return null;
        }
    }

    public JsonNode convertStringToJson(String jsonString) {
        try {
            return objectMapper.get().readTree(jsonString);
        } catch (Exception e) {
            log.error("Error converting object to JSON", e);
            return null;
        }
    }

    /*public Map<String, Object> extractProperties(JsonNode jsonNode, Map<String, Class<?>> propertiesMap) {
        Map<String, Object> extractedProperties = new HashMap<>();

        for (Map.Entry<String, Class<?>> entry : propertiesMap.entrySet()) {
            String key = entry.getKey();
            Class<?> clazz = entry.getValue();

            if (jsonNode.has(key)) {
                JsonNode propertyNode = jsonNode.get(key);
                try {
                    Object value = jsonNode.as;
                    extractedProperties.put(key, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return extractedProperties;
    }*/


}
