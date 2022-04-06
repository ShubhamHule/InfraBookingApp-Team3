package com.zensar.booking.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.booking.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);
}
