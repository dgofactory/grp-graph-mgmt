package dgo.dgmt.items.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoneyDto {
    private Double rawValue;
    private String country;
    private String format;
}
