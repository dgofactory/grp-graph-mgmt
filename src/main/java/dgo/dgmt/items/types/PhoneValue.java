package dgo.dgmt.items.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneValue {
    @JsonProperty("country")
    private int countryCode;
    @JsonProperty("area")
    private int areaArea;
    private int number;
    private int extension;
    private String type;
}
