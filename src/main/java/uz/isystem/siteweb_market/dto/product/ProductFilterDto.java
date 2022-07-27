package uz.isystem.siteweb_market.dto.product;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.FilterDto;
import uz.isystem.siteweb_market.enums.ProductType;

import java.util.List;

@Getter
@Setter
public class ProductFilterDto extends FilterDto {
    private String name;
    private Double minPrice;
    private Double maxPrice;
    private Integer rate;
    private ProductType type;
    private List<String> nameList;
    private List<ProductType> typeList;
}
