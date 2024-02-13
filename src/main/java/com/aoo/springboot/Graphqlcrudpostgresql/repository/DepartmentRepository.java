package com.aoo.springboot.Graphqlcrudpostgresql.repository;

import com.aoo.springboot.Graphqlcrudpostgresql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
}
