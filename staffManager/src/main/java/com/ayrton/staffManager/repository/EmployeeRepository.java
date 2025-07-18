package com.ayrton.staffManager.repository;

import com.ayrton.staffManager.enums.Position;
import com.ayrton.staffManager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findById(String id);

    List<Employee> findAll();

    List<Employee> findByNameIgnoreCase(String name);

    List<Employee> findByPosition(Position position);

    List<Employee> findByTelephone(String telephone);

    List<Employee> findByEmailIgnoreCase(String email);

    List<Employee> findByAddressIgnoreCase(String address);

    List<Employee> findByBaseSalary(double baseSalary);
}
