package com.zensar.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.booking.bean.Booking;
import com.zensar.booking.db.BookingDAO;

@Service
public class BookingService {

	@Autowired
	BookingDAO dao;

	public Booking addBooking(Booking booking) {
		return this.dao.save(booking);
	}
}
