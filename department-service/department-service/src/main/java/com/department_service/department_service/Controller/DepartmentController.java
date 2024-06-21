package com.department_service.department_service.Controller;

import com.department_service.department_service.DTO.DepartmentDto;
import com.department_service.department_service.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //build savedDepartment restAPi

    @PostMapping
    public ResponseEntity<DepartmentDto>saveDepartment(@RequestBody  DepartmentDto departmentDto){
        DepartmentDto saveDepartment= departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }
    @GetMapping("/getDepartments/{Id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long Id){
        DepartmentDto departmentDto= departmentService.getDepartments(Id);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
    @GetMapping("/getDepartment/{dcode}")
    public ResponseEntity<DepartmentDto> getbydepartmentcode(@PathVariable String dcode){

        DepartmentDto departmentDto= departmentService.getbydcode(dcode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}



