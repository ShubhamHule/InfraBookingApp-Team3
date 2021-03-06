package com.zensar.room.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.room.bean.Room;
import com.zensar.room.service.RoomService;

@RestController
public class RoomRestController {

	@Autowired
	RoomService service;

	@GetMapping("/room")
	public ResponseEntity<List<Room>> getAllRoom() {
		return new ResponseEntity<List<Room>>(this.service.getAllRooms(), HttpStatus.OK);
	}
}
