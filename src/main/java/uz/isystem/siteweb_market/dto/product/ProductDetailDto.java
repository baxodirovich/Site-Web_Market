package uz.isystem.siteweb_market.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.ImageDto;
import uz.isystem.siteweb_market.enums.ProductStatus;
import uz.isystem.siteweb_market.enums.ProductType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailDto {
    private String name;
    private String description;
    private Double price;
    private Integer rate;
    private LocalDateTime createdDate;
    private ProductType type;
    private ProductStatus status;
    private List<ImageDto> imageList;
}
