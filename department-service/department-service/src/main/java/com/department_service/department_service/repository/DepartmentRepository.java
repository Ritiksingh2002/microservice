package com.department_service.department_service.repository;

import com.department_service.department_service.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
Department findByDepartmentcode(String dcode);


}
