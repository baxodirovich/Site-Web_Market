package uz.isystem.siteweb_market.util;

import io.jsonwebtoken.SignatureAlgorithm;
import uz.isystem.siteweb_market.config.CustomUserDetails;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqPq";
    private final String jwtIssuer = "market.uz";
    private final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    public String generateAccessToken(UserDetails userDetails){
        CustomUserDetails user = (CustomUserDetails) userDetails;
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setId("some Id");
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setSubject(String.format("%s,%s", user.getId(), user.getUsername()));
        jwtBuilder.signWith(SignatureAlgorithm.ES256, jwtSecret);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000)));
        jwtBuilder.setIssuer(jwtIssuer);
        String jwt = jwtBuilder.compact();
        return jwt;
    }
}


