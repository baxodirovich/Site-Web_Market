package uz.isystem.siteweb_market.dto.profile;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.AddressDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileDetailDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String content;
    private ProfileStatus status;
    private String password;
    private Integer imageId;
    private ProfilRole role;
    private LocalDateTime createdData;
    private String token;
    private AddressDto address;
}
