package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CrudService<Customer>{
    final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void create(Customer entity) {
        customerDAO.save(entity);
    }

    @Override
    public Customer read(Integer id) {
        return customerDAO.show(id);
    }

    @Override
    public List<Customer> index() {
        return customerDAO.index();
    }

    @Override
    public boolean update(Customer entity, Integer id) {
        customerDAO.update(entity, id);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        customerDAO.delete(id);
        return true;
    }
}
