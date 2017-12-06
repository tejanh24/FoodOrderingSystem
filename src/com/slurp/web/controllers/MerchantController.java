package com.slurp.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.slurp.web.dao.model.Hotels;
import com.slurp.web.services.HotelService;

@Controller
public class MerchantController {

	@Autowired
	HotelService hotelService;

	@RequestMapping("/addHotel")
	public String addHotel(Model model) {
		model.addAttribute("hotels", new Hotels());
		return "addHotel";
	}

	@RequestMapping(value = "/saveHotel", method = RequestMethod.POST)
	public String saveHotel(Model model, @Valid Hotels hotel, BindingResult result) {
		System.out.println("City " + hotel.getCity());
		// model.addAttribute("hotel", hotel);
		if (result.hasErrors()) {
			return "addHotel";
		}

		hotelService.save(hotel);
		return "hotelSaved";
	}
}
