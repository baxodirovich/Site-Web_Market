package uz.isystem.siteweb_market.convertlar;

import uz.isystem.siteweb_market.dto.profile.ProfileDetailDto;
import uz.isystem.siteweb_market.entity.ProfileEntity;

public class ProfileConvertor {
    public static ProfileDetailDto toDto(ProfileEntity entity){
        if (entity == null)
            return null;
        ProfileDetailDto dto = new ProfileDetailDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setStatus(entity.getStatus());
        dto.setRole(entity.getRole());
        dto.setCreatedData(entity.getCreatedDate());
        return dto;
    }

    public static ProfileDetailDto toShortDetail(ProfileEntity entity){
        if (entity == null)
            return null;

        ProfileDetailDto dto = new ProfileDetailDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
