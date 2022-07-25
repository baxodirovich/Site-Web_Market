package uz.isystem.siteweb_market.dto.profile;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.siteweb_market.dto.FilterDto;

import java.util.List;

@Getter
@Setter
public class ProfileFilterDto extends FilterDto {
    private String name;
    private String surname;
    private String email;
    private String contact;
    private List<String> nameList;
}
