package com.employee_service.employee_service.service;

import com.employee_service.employee_service.dto.EmployeeDto;
import com.employee_service.employee_service.entity.Employee;
import com.employee_service.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;


    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee(employeeDto.getId(),employeeDto.getFirstname(),employeeDto.getLastname(),employeeDto.getEmail());
        Employee savedEmpl= employeeRepository.save(employee);

        EmployeeDto savedemp= new EmployeeDto(savedEmpl.getId(),savedEmpl.getFirstname(),savedEmpl.getLastname(),savedEmpl.getEmail());
        return savedemp;
    }

    public EmployeeDto getEmpById(Long id) {
        Employee em= employeeRepository.getReferenceById(id);
        EmployeeDto employeeDto= new EmployeeDto(em.getId(),em.getFirstname(),em.getLastname(),em.getEmail());
        return employeeDto;


    }
}
