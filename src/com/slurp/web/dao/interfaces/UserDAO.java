package com.slurp.web.dao.interfaces;

import com.slurp.web.dao.model.Authorities;
import com.slurp.web.dao.model.User;

public interface UserDAO {

	public void save(User user,String role);
	public Authorities saveAuthorities(String userName,String role);
	public User findByUserName(String userName);
	
}
