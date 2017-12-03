package com.slurp.web.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.slurp.web.dao.model.User;

@Service
public class GetUserService {

	public User getUserOfTheContext() {
		UserPrincipalService principal = (UserPrincipalService) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return principal.getUser();
	}

}
