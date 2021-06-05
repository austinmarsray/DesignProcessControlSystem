package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

/*
建立映射，将实体类映射到数据库中的一张表
 */
@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class Employee {
    @Id
    @Column(name = "employee_no")
    String employeeNo;

    String employeeName;
    char gender;
    String birthday;
    String entry;
    String team;
    String phone;
    String telphone;
    String email;
    String ID;
    String political;
    int position;
    String pwd;

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public char getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEntry() {
        return entry;
    }

    public String getTeam() {
        return team;
    }

    public String getPhone() {
        return phone;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getPolitical() {
        return political;
    }

    public int getPosition() {
        return position;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNo='" + employeeNo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", entry='" + entry + '\'' +
                ", team='" + team + '\'' +
                ", phone='" + phone + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", ID='" + ID + '\'' +
                ", political='" + political + '\'' +
                ", position=" + position +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}