package com.example.demo.dao;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Gender;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        Customer customer = new Customer();

        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setName(resultSet.getString("name"));
        customer.setSurname(resultSet.getString("surname"));
        customer.setAge(resultSet.getInt("age"));
        customer.setGender(Gender.valueOf(resultSet.getString("gender")));
        customer.setEmail(resultSet.getString("email"));

        return customer;

    }
}
