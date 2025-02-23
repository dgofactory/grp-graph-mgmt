package dgo.dgmt.items.graph;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGraph {
    private long id;
    private String label;
    private String properties;

    public <T> T readFromString(ObjectMapper objectMapper,
                                Class<T> clazz) {
        if (properties == null) {
            return null;
        }
        try {
            return  objectMapper.readValue(properties, clazz);
        } catch (Exception e) {
            return null;
        }
    }


}
