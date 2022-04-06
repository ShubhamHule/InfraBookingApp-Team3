package com.zensar.booking.bean;

import java.util.Objects;

import javax.persistence.Embeddable;

import org.springframework.lang.NonNull;

@Embeddable
public class Room {

	@NonNull
	private String code;
	@NonNull
	private int capacity;

	public Room() {
		super();
	}

	public Room(String code, int capacity) {
		super();
		this.code = code;
		this.capacity = capacity;
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
	public int hashCode() {
		return Objects.hash(capacity, code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return capacity == other.capacity && Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Room [code=" + code + ", capacity=" + capacity + "]";
	}

}
