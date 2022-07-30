package uz.isystem.siteweb_market.dto.order;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.product.ProductDetailDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderItemDetailDto {
    private Integer id;
    private Integer orderId;
    private ProductDetailDto product;
    private Integer amount;
    private LocalDateTime createdDate;
    private Double price;
}
