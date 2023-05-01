package com.ChadDarby.ThymeleafHelloWorld.repository;

import com.ChadDarby.ThymeleafHelloWorld.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        List<Employee> findAllByOrderByLastNameAsc();


}
