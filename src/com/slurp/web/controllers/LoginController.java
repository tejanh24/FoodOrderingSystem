package com.slurp.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slurp.web.services.UserPrincipalService;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping("/userHome")
	public String getUserHome(Model model, Authentication auth) {
		UserPrincipalService user = (UserPrincipalService) auth.getPrincipal();
		model.addAttribute("user", user.getUser());
		return "userHome";
	}
}
