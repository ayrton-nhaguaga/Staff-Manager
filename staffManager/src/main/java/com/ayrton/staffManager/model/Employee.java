package com.ayrton.staffManager.model;

import com.ayrton.staffManager.enums.Position;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
public class Employee {

    @Id
    private String id;
    private String name;
    private Position position;
    private String telephone;
    private String emergencyTelephone;
    private String email;
    private String address;
    private double baseSalary;
    private double finalSalary;
    private int absences;

    public double calculateFinalSalary(){
        double dailyRate = baseSalary / 22.0;

        return baseSalary - (absences * dailyRate);
    }
}
