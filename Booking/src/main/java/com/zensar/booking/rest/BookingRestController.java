package com.zensar.booking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.booking.bean.Booking;
import com.zensar.booking.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	BookingService service;

	@PostMapping("/booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		return new ResponseEntity<Booking>(this.service.addBooking(booking), HttpStatus.CREATED);
	}
}
