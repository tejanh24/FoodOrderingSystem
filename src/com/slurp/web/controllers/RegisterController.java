package com.slurp.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slurp.web.dao.model.User;
import com.slurp.web.services.MailSenderService;
import com.slurp.web.services.RegistrationService;

@Controller
public class RegisterController {

	@Autowired
	RegistrationService regService;
	
	@Autowired
	MailSenderService mailService;

	@RequestMapping("/userRegisterPage")
	public String getUserRegistrationPage(Model model) {
		model.addAttribute("user", new User());
		return "userRegistration";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(Model model, @Valid User user, BindingResult result) {
		//model.addAttribute("user", user);
		if (result.hasErrors())
			return "userRegistration";
		if (regService.saveNewUser(user, user.getRole())) {
			mailService.setUser(user);
			Thread mailThread = new Thread(mailService);
			mailThread.start();
			return "registrationSuccess";
		}

		return "registerError";
	}
}
