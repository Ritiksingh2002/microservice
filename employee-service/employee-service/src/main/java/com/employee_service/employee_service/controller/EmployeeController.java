package com.employee_service.employee_service.controller;

import com.employee_service.employee_service.dto.APIResponseDto;
import com.employee_service.employee_service.dto.EmployeeDto;
import com.employee_service.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;


    @PostMapping("/savedEmp")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedDto= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);

    }
    @GetMapping("/getemp/{Id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long Id){
        APIResponseDto apiResponseDto= employeeService.getEmpById(Id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);

    }

}
