package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody Employee requestEmployee) {
        String employeeNo = requestEmployee.getEmployeeNo();
        Employee employee = employeeService.get(employeeNo, requestEmployee.getPwd());//---why
        if (null == employee) {
            return ResultFactory.buildFailResult("error!");
        } else {
            System.out.println(employee);
            return ResultFactory.buildSuccessResult(employee);
        }
    }
}
