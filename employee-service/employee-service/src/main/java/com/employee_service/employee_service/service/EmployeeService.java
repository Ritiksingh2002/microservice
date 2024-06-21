package com.employee_service.employee_service.service;

import com.employee_service.employee_service.dto.APIResponseDto;
import com.employee_service.employee_service.dto.DepartmentDto;
import com.employee_service.employee_service.dto.EmployeeDto;
import com.employee_service.employee_service.entity.Employee;
import com.employee_service.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Service

@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//private WebClient webClient;
private APIClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee(employeeDto.getId(),employeeDto.getFirstname(),employeeDto.getLastname(),employeeDto.getEmail(),employeeDto.getDepartmentcode());
        Employee savedEmpl= employeeRepository.save(employee);

        EmployeeDto savedemp= new EmployeeDto(savedEmpl.getId(),savedEmpl.getFirstname(),savedEmpl.getLastname(),savedEmpl.getEmail(),savedEmpl.getDepartmentcode());
        return savedemp;
    }

    public APIResponseDto getEmpById(Long id) {
        Employee em= employeeRepository.findById(id).get();
       // ResponseEntity<DepartmentDto>responseEntity=restTemplate.getForEntity("https://localhost:8080/api/departments/"+em.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/getDepartment/" + em.getDepartmentcode())
//                .retrieve().bodyToMono(DepartmentDto.class).block();


       // DepartmentDto departmentDto=responseEntity.getBody();


        DepartmentDto departmentDto=apiClient.getbydepartmentcode(em.getDepartmentcode());
        EmployeeDto employeeDto= new EmployeeDto(em.getId(),em.getFirstname(),em.getLastname(),em.getEmail(),em.getDepartmentcode());


        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;


    }

}
