package com.employee_service.employee_service.service;

import com.employee_service.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/getDepartment/{dcode}")
    DepartmentDto getbydepartmentcode(@PathVariable String dcode);

}
