package com.employee_service.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    private String dname;
    private String description;
    private String departmentcode;
}
