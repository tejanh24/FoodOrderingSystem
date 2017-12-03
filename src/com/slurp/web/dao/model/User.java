package com.slurp.web.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Size(min = 1, message = "Please enter a valid first name.")
	private String firstName;
	@NotNull
	@Size(min = 1, message = "Please enter a valid last name.")
	private String lastName;
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Please enter a valid email-id.")
	private String username;
	@NotNull
	@Size(min = 6,message = "Password must be between 6 and 10 characters.")
	private String password;
	@Transient
	private String confrmPass;
	private int enabled;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Authorities> roles = new ArrayList<Authorities>();
	@Transient
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Authorities> getRoles() {
		return roles;
	}

	public void setRoles(List<Authorities> roles) {
		this.roles = roles;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getConfrmPass() {
		return confrmPass;
	}

	public void setConfrmPass(String confrmPass) {
		this.confrmPass = confrmPass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
