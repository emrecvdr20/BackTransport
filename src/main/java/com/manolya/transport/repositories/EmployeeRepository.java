package com.manolya.transport.repositories;

import com.manolya.transport.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
