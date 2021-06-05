package com.example.demo.service;

import com.example.demo.dao.ClientDAO;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientDAO clientDAO;

    public Client get(String clientNo){
        return clientDAO.getByClientNo(clientNo);
    }
    public List<Client> getClientList(){
        return clientDAO.getAllByClientNoNotNull();
    }

    public int add(Client client){
        if (null != clientDAO.getByClientNo(client.getClientNo())){
            return 2;
        }
        Client client1 = clientDAO.save(client);
        if (null == client1)
            return 0;
        return 1;
    }

    public int deleteByID(String clientNo){
        Client client = clientDAO.getByClientNo(clientNo);
        if (null == client)
            return -1;
        clientDAO.deleteById(clientNo);
        return 1;
    }
    public int update(Client client){
        Client client1 = clientDAO.save(client);
        if (null == client1)
            return -1;
        return 1;
    }
}
