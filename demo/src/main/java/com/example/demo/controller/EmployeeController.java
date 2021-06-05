package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //添加
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping("/api/employee/add")
    public Result addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        int result = employeeService.add(employee);
        if (result == 1)
            return ResultFactory.buildSuccessResult("更新成功");
        return ResultFactory.buildFailResult("更新失败");
    }

    //根据employeeNo删除
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping("/api/employee/delete")
    public Result delEmployee(@RequestBody Employee employee){
        int result = employeeService.delete(employee.getEmployeeNo());
        if (result == 1)
            return ResultFactory.buildSuccessResult("删除成功");
        return ResultFactory.buildFailResult("删除失败");
    }

    //根据employeeNo查询
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping(value = "/api/employee/search",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
    public Result search(@RequestBody Employee employee){
        Employee employee1 = employeeService.search(employee.getEmployeeNo());
        if (null != employee1)
            return ResultFactory.buildSuccessResult(employee1);
        return ResultFactory.buildFailResult("查询的用户不存在");
    }

    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @GetMapping("/api/employee/getList")
    public Result getList(){
        return ResultFactory.buildSuccessResult(employeeService.getList());
    }

}
