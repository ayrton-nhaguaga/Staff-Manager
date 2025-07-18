package com.ayrton.staffManager.dto;

import com.ayrton.staffManager.enums.Position;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {

    private String id;

    @NotNull
    @Size(min = 0, max = 75)
    private String name;

    @NotNull
    private Position position;

    @NotNull
    @Size(min = 0, max = 25)
    private String telephone;

    @NotNull
    @Size(min = 0, max = 25)
    private String emergencyTelephone;

    @NotNull
    @Size(min = 0, max = 100)
    private String email;

    @NotNull
    @Size(min = 0, max = 100)
    private String address;

    @NotNull
    private double baseSalary;

    private double finalSalary;

    private int absences;
}
