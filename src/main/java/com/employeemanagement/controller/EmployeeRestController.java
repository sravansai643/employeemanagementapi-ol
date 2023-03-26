package com.employeemanagement.controller;
import java.util.List;
import java.util.Map;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model, Employee employee) {
        // Employee employee = new Employee();
        model.addAttribute("employee", employee);
        System.out.println("done");
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        System.out.println("employee"+employee);
        return "success";
    }

    @GetMapping("/get_employeeForm")
    public String getEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "get_employee";
    }

    @GetMapping("/getEmployee")
    public ModelAndView getEmployee(@RequestParam Integer eno) {
        ModelAndView mav = new ModelAndView("employee_list");
        Employee employee = employeeService.getEmployee(eno);
        mav.addObject("employee", employee);
        System.out.println("employee = " + employee);
        return mav;
    }

    @GetMapping("/employee_list")
    public String getEmployee() {
        return "employee_list";
    }

    @GetMapping("/getAllEmployees")
    public String getAllEmployees(Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("employee_list");
        List<Employee> employee = employeeService.getEmployees();
        model.put("employee", employee);
        System.out.println("employee = " + employee);
        return "employee_list";
    }

    @GetMapping("/update_employeeForm")
    public String updateEmployee(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/delete_employeeForm")
    public String deleteEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "delete_employee";
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer eno) {
        System.out.println("eno = " + eno);
        employeeService.deleteEmployee(eno);
        return "success";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "success";
    }

}
