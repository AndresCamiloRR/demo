package com.co.eventos.icesi.demo.postgresql.repository;

import com.co.eventos.icesi.demo.postgresql.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
