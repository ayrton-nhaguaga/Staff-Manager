package com.ayrton.staffManager.service;


import com.ayrton.staffManager.dto.EmployeeDTO;
import com.ayrton.staffManager.enums.Position;
import com.ayrton.staffManager.model.Employee;
import com.ayrton.staffManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO dto){
        Employee service = new Employee();
        service.setId(dto.getId());
        service.setName(dto.getName());
        service.setPosition(dto.getPosition());
        service.setTelephone(dto.getTelephone());
        service.setEmergencyTelephone(dto.getEmergencyTelephone());
        service.setEmail(dto.getEmail());
        service.setAddress(dto.getAddress());
        service.setBaseSalary(dto.getBaseSalary());
        service.setAbsences(0);
        return employeeRepository.save(service);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByNameIgnoreCase(name);
    }

    public List<Employee> getEmployeeByPosition(Position position){
        return employeeRepository.findByPosition(position);
    }

    public List<Employee> getEmployeeByTelephone(String telephone){
        return employeeRepository.findByTelephone(telephone);
    }

    public List<Employee> getByEmailIgnoreCase(String email){
        return employeeRepository.findByEmailIgnoreCase(email);
    }

    public List<Employee> getByAddressIgnoreCase(String address){
        return employeeRepository.findByAddressIgnoreCase(address);
    }

    public List<Employee> getByBaseSalary(double baseSalary){
        return employeeRepository.findByBaseSalary(baseSalary);
    }

    public Employee markAbsences(String name){
        List<Employee> e = employeeRepository.findByNameIgnoreCase(name);
        Employee employee = e.get(0);
        employee.setAbsences(employee.getAbsences() + 1);
        employee.setFinalSalary(employee.calculateFinalSalary());
        return employeeRepository.save(employee);
    }



    public List<Employee> updateEmployee(String name, EmployeeDTO dto){
        List<Employee> employees = employeeRepository.findByNameIgnoreCase(name);

        for (Employee e : employees){
            e.setName(dto.getName());
            e.setTelephone(dto.getTelephone());
            e.setEmergencyTelephone(dto.getEmergencyTelephone());
            e.setEmail(dto.getEmail());
            e.setPosition(dto.getPosition());
            e.setAddress(dto.getAddress());
            e.setBaseSalary(dto.getBaseSalary());
            employeeRepository.save(e);
        }
        return employees;
    }

    public boolean deleteEmployee(String name){
        List<Employee> employees = employeeRepository.findByNameIgnoreCase(name);
        if (!employees.isEmpty()){
            employeeRepository.deleteAll();
            return true;
        }
        return false;
    }

}
