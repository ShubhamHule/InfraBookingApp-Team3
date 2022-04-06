package com.zensar.booking.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.booking.bean.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
