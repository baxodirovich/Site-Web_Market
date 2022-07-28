package uz.isystem.siteweb_market.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.isystem.siteweb_market.entity.ProfileEntity;
import uz.isystem.siteweb_market.repository.ProfileRepository;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ProfileRepository repository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<ProfileEntity> optional = repository.findByEmail(s);
        optional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        ProfileEntity profile = optional.get();
        return new CustomUserDetails(profile);
    }
}
