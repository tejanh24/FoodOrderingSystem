package com.slurp.web.dao.interfaces;

import java.util.List;

import com.slurp.web.dao.model.Hotels;

public interface HotelsDAO {

	public List<String> getListOfHotels();
	public List<Hotels> getHotelsByMerchantID(int merchantID);
	public void save(Hotels hotel);
}
