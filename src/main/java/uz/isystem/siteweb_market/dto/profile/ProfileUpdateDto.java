package uz.isystem.siteweb_market.dto.profile;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ProfileUpdateDto {
    @NotEmpty(message = ("Please provide a name"))
    private String name;
    @NotEmpty(message = ("Please provide a surname"))
    private String surname;
    @NotEmpty(message = ("Please provide a contact"))
    private String contact;
    @NotEmpty(message = ("image id error"))
    private Integer imageId;
}
