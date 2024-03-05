package org.example.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Employee {
    private int EmployeeId;
    private String EmployeeName;
    private String EmployeeCity;
    private int EmployeePhone;
}
