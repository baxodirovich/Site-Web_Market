package uz.isystem.siteweb_market.dto.order;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.AddressDto;
import uz.isystem.siteweb_market.enums.PaymentType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class OrderCreateDto {
    private Integer id;
    private String requirement;
    private AddressDto addressDto;
    @NotBlank
    private String contact;
    @NotNull
    private PaymentType paymentType;
    @Size(min = 1)
    private List<OrderItemCreateDto> itemList;
}
