package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Client;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.List;
/*
    业务逻辑
*/

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    //get the employ according to Number and Password if he exit
    public Employee get(String employeeNo, String pwd){
        return employeeDAO.getByEmployeeNoAndPwd(employeeNo, pwd);
    }

    public boolean isExist(String  employeeNo){
        Employee employee = employeeDAO.findByEmployeeNo(employeeNo);
        return null != employee;
    }

    // add employee.success return 1,false return 0,if employee exist return 2
    public int add(Employee employee) {
        String employeeNo = employee.getEmployeeNo();
        String employeeName = employee.getEmployeeName();
        char gender = employee.getGender();
        String birthday = employee.getBirthday();
        String entry = employee.getEntry();
        String team = employee.getTeam();
        String phone  = employee.getPhone();
        String telphone = employee.getTelphone();
        String email = employee.getEmail();
        String ID = employee.getID();
        String political = employee.getPolitical();
        int position = employee.getPosition();
        String pwd = employee.getPwd();

        employeeNo = HtmlUtils.htmlEscape(employeeNo);
        employee.setEmployeeNo(employeeNo);

        employeeName = HtmlUtils.htmlEscape(employeeName);
        employee.setEmployeeName(employeeName);

        team = HtmlUtils.htmlEscape(team);
        employee.setTeam(team);

        phone = HtmlUtils.htmlEscape(phone);
        employee.setPhone(phone);

        telphone = HtmlUtils.htmlEscape(telphone);
        employee.setTelphone(telphone);

        email = HtmlUtils.htmlEscape(email);
        employee.setEmail(email);

        ID = HtmlUtils.htmlEscape(ID);
        employee.setID(ID);

        political = HtmlUtils.htmlEscape(political);
        employee.setPolitical(political);

        pwd = HtmlUtils.htmlEscape(pwd);
        employee.setPwd(pwd);

        if (employeeNo.equals("") || pwd.equals("") || gender == 0 || ID.equals("") || position == 0){
            return 0;
        }


        Employee employee1 = employeeDAO.save(employee);
        if (null == employee1)
            return -1;
        return 1;
    }

    //delete by employNo.delete success return 1 ,else return 0
    public int delete(String employeeNo){
        boolean exist = isExist(employeeNo);
        if (!exist){
            return 0;
        }
        employeeDAO.deleteById(employeeNo);
        return 1;
    }

    //search by employeeNo
    public Employee search(String employNo){
        return employeeDAO.findByEmployeeNo(employNo);
    }
    public void update(Employee employee){
        employeeDAO.save(employee);
    }

    //return employeeList
    public List<Employee> getList(){
        return employeeDAO.getAllByEmployeeNoIsNot("boss");
    }
}
