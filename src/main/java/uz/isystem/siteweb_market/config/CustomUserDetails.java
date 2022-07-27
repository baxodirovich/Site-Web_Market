package uz.isystem.siteweb_market.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.isystem.siteweb_market.entity.ProfileEntity;
import uz.isystem.siteweb_market.enums.ProfileStatus;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private int id;
    private String username;
    private String password;
    private boolean enabled;

    private List<GrantedAuthority> authorityList;

    public CustomUserDetails(ProfileEntity profile){
        id = profile.getId();
        username = profile.getEmail();
        password = profile.getPassword();
        enabled = profile.getStatus().equals(ProfileStatus.ACTIVE);

        this.authorityList = Arrays.asList(new SimpleGrantedAuthority(profile.getRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString(){
        return "CustomUserDetails{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled='" + enabled +
                ", authorityList=" + authorityList +
                '}';
    }
}
