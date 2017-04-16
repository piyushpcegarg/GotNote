package com.gotprint.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.gotprint.model.CustomUser;
import com.gotprint.model.UserMst;

@Repository
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String emailId = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		UserMst userMst = validateUser(emailId,password);
		if(userMst != null) {
			UserDetails userDetails = createUserDetails(userMst);
			return new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException("EmailId/Password is incorrect");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private UserMst validateUser(String emailId, String password) {
		return userRepository.findByEmailIdAndPassword(emailId, password);
	}
	
	private UserDetails createUserDetails(UserMst userMst) {
		CustomUser customUser = new CustomUser(userMst.getEmailId(), userMst.getPassword(), new ArrayList<>(), userMst.getUserId());
		return customUser;
	}

}
