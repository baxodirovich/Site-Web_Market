package uz.isystem.siteweb_market.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.siteweb_market.dto.AuthDto;
import uz.isystem.siteweb_market.dto.RegistrationDto;
import uz.isystem.siteweb_market.dto.profile.ProfileDetailDto;
import uz.isystem.siteweb_market.repository.ProfileRepository;
import uz.isystem.siteweb_market.service.AuthorizationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthorizationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
    @Autowired
    private AuthorizationService service;
    @Autowired
    private ProfileRepository profileRepository;

    @PutMapping("/authorization")
    public ResponseEntity<?> authorization(@Valid @RequestBody AuthDto dto) {
        logger.info("Authorization: {}" + dto);
        ProfileDetailDto result = service.authorization(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Valid @RequestBody RegistrationDto dto){
        logger.info("Authorization: {}" + dto);
        String result = service.registration(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/verification/{jwt}")
    public ResponseEntity<?> registration(@PathVariable("jwt") String jwt){
        String result = service.verification(jwt);
        return ResponseEntity.ok(result);
    }
}
