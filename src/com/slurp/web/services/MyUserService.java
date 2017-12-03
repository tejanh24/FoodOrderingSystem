package com.slurp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slurp.web.dao.impl.UserImpl;
import com.slurp.web.dao.model.User;

@Service("userService")
public class MyUserService implements UserDetailsService{

	@Autowired
	UserImpl userImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userImpl.findByUserName(username);
		if(user == null)
			throw new UsernameNotFoundException(username);
		return new UserPrincipalService(user);
	}

}
