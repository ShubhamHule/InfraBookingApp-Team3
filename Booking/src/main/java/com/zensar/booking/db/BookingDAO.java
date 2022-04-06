package com.zensar.booking.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.booking.bean.Booking;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Integer> {

}
