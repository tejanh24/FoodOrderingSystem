package com.slurp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slurp.web.services.GetUserService;
import com.slurp.web.services.HotelService;

@Controller
public class UserController {

	@Autowired
	GetUserService userService;
	@Autowired
	HotelService hotelService;

	@RequestMapping(value = "/userDetails")
	public String getUserDetails(Model model) {
		model.addAttribute("user", userService.getUserOfTheContext());
		return "userDetails";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String getLogOut() {
		return "logout";
	}

	@RequestMapping("/hotelsList")
	public String getHotels() {
		hotelService.getListOfHotels();
		return "hotels";
	}

}
