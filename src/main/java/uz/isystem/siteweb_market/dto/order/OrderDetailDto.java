package uz.isystem.siteweb_market.dto.order;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.AddressDto;
import uz.isystem.siteweb_market.dto.profile.ProfileDetailDto;
import uz.isystem.siteweb_market.enums.OrderStatus;
import uz.isystem.siteweb_market.enums.PaymentType;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class OrderDetailDto {
    private Integer id;
    private ProfileDetailDto profile;

    private String requirement;
    private String contact;
    private AddressDto address;

    private Double deliveryCost;
    private PaymentType paymentType;
    private OrderStatus status;

    private LocalDateTime deliveryDate;
    private LocalDateTime createdDate;

    private List<OrderItemDetailDto> orderItemList;
}
