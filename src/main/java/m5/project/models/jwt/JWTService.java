package m5.project.models.jwt;
import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import m5.project.models.user.UserDto;

@Service
@RequiredArgsConstructor
public class JWTService {
	
	@Autowired
	private ObjectMapper om;
	
	private static String secretKey="1q2w3e4r";

	
	
	public String makeJwtToken(UserDto user) {
		Date now = new Date();
		
		return Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.setIssuer("VoiceRecognitionProject") 
				.setIssuedAt(now) 
				.setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) 
				.claim("memId",user.getMemId())
				.claim("name", user.getName())
				.claim("userId", user.getUserId())
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}

	public Claims parseJwtToken(String authorizationHeader) {
				
		validationAuthorizationHeader(authorizationHeader); // (1)
		String token = extractToken(authorizationHeader); // (2)

		return Jwts.parser().setSigningKey(secretKey) // (3)
				.parseClaimsJws(token) // (4)
				.getBody();
	}

	private void validationAuthorizationHeader(String header) {
		if (header == null || !header.startsWith("Bearer ")) {
			throw new IllegalArgumentException();
		}
	}

	private String extractToken(String authorizationHeader) {
		return authorizationHeader.substring("Bearer ".length());
	}
}
