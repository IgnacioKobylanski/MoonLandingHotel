package com.moonlandinghotel.moon_landing_hotelweb.security.config;




import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secretKey = "secret1234";
    private long validity = 3600000L;


}
