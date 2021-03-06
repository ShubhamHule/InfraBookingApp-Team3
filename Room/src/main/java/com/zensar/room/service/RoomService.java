package com.zensar.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.room.bean.Room;
import com.zensar.room.db.RoomDAO;

@Service
public class RoomService {

	@Autowired
	RoomDAO dao;

	public List<Room> getAllRooms() {
		return this.dao.findAll();
	}
}
