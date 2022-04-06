package com.zensar.room.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.room.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);
}
