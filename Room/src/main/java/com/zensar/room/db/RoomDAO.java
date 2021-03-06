package com.zensar.room.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.room.bean.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, Integer> {

}
