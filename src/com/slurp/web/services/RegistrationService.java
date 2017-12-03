package com.slurp.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.slurp.web.dao.impl.UserImpl;
import com.slurp.web.dao.model.User;

@Service
public class RegistrationService {

	@Autowired
	UserImpl userImpl;
	@Autowired
	PasswordEncoder passwordEncoder;

	public boolean saveNewUser(User user, String role) {
		user.setEnabled(1);
		if (userImpl.findByUserName(user.getUsername()) == null) {
			try {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userImpl.save(user, role);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return false;
	}
}
