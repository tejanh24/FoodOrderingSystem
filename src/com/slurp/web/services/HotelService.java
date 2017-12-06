package com.slurp.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slurp.web.dao.interfaces.HotelsDAO;
import com.slurp.web.dao.model.Hotels;

@Service
public class HotelService {

	@Autowired
	HotelsDAO hotelDAO;
	@Autowired
	GetUserService userService;

	public List<String> getListOfHotels() {
		// TODO Auto-generated method stub
		return hotelDAO.getListOfHotels();
	}

	public List<Hotels> getHotelsOfMerchant(int merchantID) {
		// TODO Auto-generated method stub
		return hotelDAO.getHotelsByMerchantID(merchantID);
	}

	public void save(Hotels hotel) {
		// TODO Auto-generated method stub
		hotel.setMerchantID(userService.getUserOfTheContext().getId());
		hotelDAO.save(hotel);
	}

}
