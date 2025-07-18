package com.ayrton.staffManager.controller;

import com.ayrton.staffManager.dto.EmployeeDTO;
import com.ayrton.staffManager.enums.Position;
import com.ayrton.staffManager.model.Employee;
import com.ayrton.staffManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO dto){
        Employee employee = employeeService.createEmployee(dto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@RequestParam String id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name){
        List<Employee> employees = employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<List<Employee>> getEmployeeByPosition(@RequestParam Position position){
        List<Employee> employees = employeeService.getEmployeeByPosition(position);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/telephone")
    public ResponseEntity<List<Employee>> getEmployeeByTelephone(@RequestParam String telephone){
        List<Employee> employees = employeeService.getEmployeeByTelephone(telephone);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<Employee>> getByEmailIgnoreCase(@RequestParam String email){
        List<Employee> employees = employeeService.getByEmailIgnoreCase(email);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Employee>> getByAddressIgnoreCase(@RequestParam String address){
        List<Employee> employees = employeeService.getByAddressIgnoreCase(address);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getByBaseSalary(@RequestParam double baseSalary){
        List<Employee> employees = employeeService.getByBaseSalary(baseSalary);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/name/mark-absences")
    public ResponseEntity<Employee> markAbsences(@RequestParam String name){
        Employee employee = employeeService.markAbsences(name);
        if (employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
            return ResponseEntity.ok(employee);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Employee>> updateEmployee(@RequestParam String name,@RequestBody EmployeeDTO dto){
        List<Employee> updatedList = employeeService.updateEmployee(name, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteEmployeeByNome(@RequestParam String name){
        if(employeeService.deleteEmployee(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
