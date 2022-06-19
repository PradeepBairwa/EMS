package com.glic.ems.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glic.ems.customexception.BusinessException;
import com.glic.ems.helper.JwtUtil;
import com.glic.ems.model.JwtRequest;
import com.glic.ems.model.JwtResponse;
import com.glic.ems.serviceImpl.CustomUserDetailsServiceImpl;


@RestController
@CrossOrigin
public class JwtController {
	
	@Autowired
	private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	
	
	@RequestMapping(value="/token",method=RequestMethod.POST)
	public ResponseEntity<?> generateToken( @RequestBody JwtRequest jwtRequest)throws Exception{
		System.out.println(jwtRequest);
		
//		try { 
//			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getPassword(), jwtRequest.getUsername()));
//			
//		}catch(UsernameNotFoundException e){
//			e.printStackTrace();
//			throw new BusinessException("100","Bad credenitials...");
//		}
//	UserDetails userDetails=	this.customUserDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
//	String token =this.jwtUtil.generateToken(userDetails);
//	System.out.println("JWT "+token);
//	 
//	return ResponseEntity.ok(new JwtResponse(token));
//		
//	}
		
		try {
			
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not Found");
		}
		
		
	UserDetails userDetails = this.customUserDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
	String token=this.jwtUtil.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	private void authenticate(String username,String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("User Disabled "+e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
		
	}
	
	

}
