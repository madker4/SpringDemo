package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerDAO {

   private final JdbcTemplate  jdbcTemplate;
 //private final NamedParameterJdbcOperations jdbcTemplate;

    @Autowired
    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> index() {

        return jdbcTemplate.query("select * from xx_saloid_java_customer",new BeanPropertyRowMapper<>(Customer.class));

    }
    public Customer show(Integer id)
    {
//        final HashMap<String,Object> params = new HashMap<>(1 );
//
//        params.put("id", id);

        return jdbcTemplate.query("select * from xx_saloid_java_customer c where c.CUSTOMER_ID = :id"
             //   ,params,new CustomerMapper());
                ,new BeanPropertyRowMapper<>(Customer.class), id).stream().findAny().orElse(null);
    }

    public void save(Customer c) {
        final HashMap<String,Object> params = new HashMap<>(5 );

        params.put("name",c.getName());
        params.put("surname",c.getSurname());
        params.put("age",c.getAge());
        params.put("gender",c.getGender().toString());
        params.put("email",c.getEmail());

        jdbcTemplate.update("insert into xx_saloid_java_customer(name,surname,age,gender,email) " +
                "values(:name,:surname,:age,:gender,:email)",params);

    }

    public void update(Customer customer, int id) {

        String sql = "update xx_saloid_java_customer set name = ? ,surname = ? ,age = ?,gender = ?,email = ? " +
                    "where CUSTOMER_ID = ?";

        jdbcTemplate.update(sql, customer.getName(), customer.getSurname(), customer.getAge(),
                                 customer.getGender().toString(), customer.getEmail(), id);
    }

    public void delete(int id) {
        String sql = "delete from xx_saloid_java_customer where CUSTOMER_ID = ?";

        jdbcTemplate.update(sql,id);

    }
}
