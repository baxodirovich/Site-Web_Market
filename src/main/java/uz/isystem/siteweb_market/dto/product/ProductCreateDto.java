package uz.isystem.siteweb_market.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isystem.siteweb_market.enums.ProductType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreateDto {
    @NotBlank(message = ("Invalid name"))
    private String name;
    @NotEmpty(message = ("Can't be empty"))
    private String description;
    @NotEmpty
    private String descriptionUz;
    @NotEmpty
    private String descriptionRu;
    @NotBlank(message = ("Invalid price"))
    private Double price;
    @NotBlank
    private ProductType type;
}
