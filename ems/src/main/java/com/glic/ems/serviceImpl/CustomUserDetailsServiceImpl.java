package com.glic.ems.serviceImpl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Username = "+username);
		String name="Pradeep";
		if(username.equals(name)) {
			return new User("Pradeep","Bairwa",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found...");
		}
	}
      
}
