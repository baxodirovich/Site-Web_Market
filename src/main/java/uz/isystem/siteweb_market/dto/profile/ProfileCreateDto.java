package uz.isystem.siteweb_market.dto.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.AddressDto;
import uz.isystem.siteweb_market.enums.ProfileRole;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ProfileCreateDto {
    private Integer id;
    @NotBlank(message = ("Please provide a name"))
    private String name;
    @NotBlank(message = ("Please provide a surname"))
    private String surname;
    @NotBlank(message = ("Please provide a email"))
    private String email;
    @NotBlank(message = ("Please provide a content"))
    private String contact;
    @NotBlank(message = ("Please provide a password"))
    private String password;
    @NotBlank(message = ("Image id error"))
    private Integer imageId;
    @NotNull
    private ProfileRole role;
    @NotNull
    private AddressDto address;
}
