package uz.isystem.siteweb_market.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class RegistrationDto {
    @NotEmpty(message = "Please provide a name")
    private String name;

    @NotBlank(message = "Please provide surname")
    private String surname;

    @Email(message = "Pleas provide email")
    private String email;

    @NotEmpty(message = "Please provide a contact")
    private String content;

    @NotBlank(message = "Please provide a password")
    @Size(min = 8, message = ("Password must be less than 8 length"))
    private String password;

    private AddressDto address;
}

