package com.ChadDarby.ThymeleafHelloWorld.controller;

import com.ChadDarby.ThymeleafHelloWorld.entity.Employee;
import com.ChadDarby.ThymeleafHelloWorld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping(value = (""))
//    public String listEmployees (Model theModel){
//        Employee emp1 = new Employee(1,"mahmoud","bdran","mahmoud.bdran@gmail.com");
//        Employee emp2 = new Employee(2,"ahmed","omar","mahmoud.bdran@gmail.com");
//        Employee emp3 = new Employee(3,"hassan","saad","mahmoud.bdran@gmail.com");
//        List<Employee> employees = new ArrayList<>();
//
//
//        employees.add(emp1);
//        employees.add(emp2);
//        employees.add(emp3);
//        theModel.addAttribute("employees",employees);
//        return "list-employees";
//
//    }
    @Autowired
    EmployeeService employeeService;
//    @GetMapping("/list")
//    public String findAll(Model model){
//        List<Employee> employees = employeeService.findAll();
//        model.addAttribute("employees", employees);
//        return "list-employees";
//    }
    @GetMapping("/list")
    public String findAll(Model model){
        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        //save the employe
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
    model.addAttribute("employee",employeeService.findById(id));
    return "/employees/edit_employee";
    }
    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Long id ,
                                 @ModelAttribute("employee") Employee employee,
                                 Model model){
        Employee existEmployee = employeeService.findById(id);
        existEmployee.setId(id);
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setEmail(employee.getEmail());
        employeeService.update(existEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
        return "redirect:/employees/list";
    }


}
