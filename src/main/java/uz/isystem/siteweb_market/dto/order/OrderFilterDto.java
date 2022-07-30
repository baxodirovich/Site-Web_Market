package uz.isystem.siteweb_market.dto.order;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.FilterDto;

@Getter
@Setter
public class OrderFilterDto extends FilterDto {
    private Integer profileId;
    private Integer productId;
    private String orderDate;
}
