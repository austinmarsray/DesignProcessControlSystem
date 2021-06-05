package com.example.demo.dao;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,String> {
    Client getByClientNo(String clientNo);
    List<Client> getAllByClientNoNotNull();
}
