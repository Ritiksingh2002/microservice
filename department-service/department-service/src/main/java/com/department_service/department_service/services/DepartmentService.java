package com.department_service.department_service.services;

import com.department_service.department_service.DTO.DepartmentDto;
import com.department_service.department_service.Entity.Department;
import com.department_service.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;


    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        //convert dto to entity
        Department department= new Department( departmentDto.getId(),
        departmentDto.getDescription(),
        departmentDto.getDname(),
        departmentDto.getDepartmentcode());

        Department savedDEpartment=departmentRepository.save(department);
       //convert entity to dto because dto is returned
        DepartmentDto savedDepartmentDTo= new DepartmentDto(savedDEpartment.getId(),savedDEpartment.getDname(),savedDEpartment.getDescription(),savedDEpartment.getDepartmentcode());
        return savedDepartmentDTo;
    }

    public DepartmentDto getDepartments(Long id) {
        Department savedDEpartment= departmentRepository.getReferenceById(id);
        DepartmentDto savedDepartmentDTo= new DepartmentDto(savedDEpartment.getId(),savedDEpartment.getDname(),savedDEpartment.getDescription(),savedDEpartment.getDepartmentcode());
        return savedDepartmentDTo;

    }

    public DepartmentDto getbydcode(String dcode) {
        Department dbycode=departmentRepository.findByDepartmentcode(dcode);
        DepartmentDto dBycode=new DepartmentDto(dbycode.getId(),dbycode.getDname(),dbycode.getDescription(),dbycode.getDepartmentcode());
        return dBycode;
    }
}
