package com.example.task10.controller;

import com.example.task10.entity.Employee;
import com.example.task10.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index"; // Return the view name for the form
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "displayAll"; // Return the view name for displaying all employees
    }

    @GetMapping("/display/{employeeId}")
    public String displayById(@PathVariable String employeeId, Model model) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "display"; // Return the view name for displaying a specific employee
   }


}
