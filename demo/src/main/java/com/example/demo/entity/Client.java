package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Client {
    @Id
    @Column(name = "clientNo")
    String clientNo;
    String clientName;
    String phone;
    String telphone;
    String QQ;
    String email;
    String Funit;
    String Sunit;
    String Tunit;

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFunit(String funit) {
        Funit = funit;
    }

    public void setSunit(String sunit) {
        Sunit = sunit;
    }

    public void setTunit(String tunit) {
        Tunit = tunit;
    }

    public String getClientNo() {
        return clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhone() {
        return phone;
    }

    public String getTelphone() {
        return telphone;
    }

    public String getQQ() {
        return QQ;
    }

    public String getEmail() {
        return email;
    }

    public String getFunit() {
        return Funit;
    }

    public String getSunit() {
        return Sunit;
    }

    public String getTunit() {
        return Tunit;
    }


}
