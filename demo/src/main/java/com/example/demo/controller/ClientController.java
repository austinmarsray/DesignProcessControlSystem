package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    //添加
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping("/api/client/add")
    public Result addClient(@RequestBody Client client){
        int result = clientService.add(client);
        if (result == 1)
            return ResultFactory.buildSuccessResult("添加成功");
        if (result == 2)
            return ResultFactory.buildFailResult("添加失败,用户已存在");
        return ResultFactory.buildFailResult("添加失败");
    }

    //删除
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping("/api/client/delete")
    public Result deleteByID(@RequestBody Client client){
        int result = clientService.deleteByID(client.getClientNo());
        if (result == 1)
            return ResultFactory.buildSuccessResult("删除成功!");
        return ResultFactory.buildFailResult("删除失败!");
    }

    //更新
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @PostMapping("/api/client/update")
    public Result  update(@RequestBody Client client){
        int result = clientService.update(client);
        if (result == 1)
            return ResultFactory.buildSuccessResult("更新成功");
        return ResultFactory.buildFailResult("更新失败");
    }

    //列表
    @CrossOrigin(origins = "http://localhost:8080",allowCredentials = "true")
    @GetMapping("/api/client/getList")
    public Result getList(){
        return ResultFactory.buildSuccessResult(clientService.getClientList());
    }
}
