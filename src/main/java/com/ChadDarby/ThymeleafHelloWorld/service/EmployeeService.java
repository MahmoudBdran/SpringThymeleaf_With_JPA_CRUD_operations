package com.ChadDarby.ThymeleafHelloWorld.service;

import com.ChadDarby.ThymeleafHelloWorld.entity.Employee;
import com.ChadDarby.ThymeleafHelloWorld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllByOrderByLastNameAsc(){
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).get();

    }

    public void save (Employee employee){
        employeeRepository.save(employee);

    }
    public void update (Employee employee){
        employeeRepository.save(employee);

    }

    public void delete (Long id){
        employeeRepository.deleteById(id);

    }
    public void deleteById (Long id){
        employeeRepository.deleteById(id);
    }







}
