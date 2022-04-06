package com.zensar.room.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Room {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String code;
	@NonNull
	private int capacity;

	public Room() {
		super();
	}

	public Room(int id) {
		super();
		this.id = id;
	}

	public Room(String code, int capacity) {
		super();
		this.code = code;
		this.capacity = capacity;
	}

	public Room(int id, String code, int capacity) {
		super();
		this.id = id;
		this.code = code;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", code=" + code + ", capacity=" + capacity + "]";
	}

}
