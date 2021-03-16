package com.example.demo.dao;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByCityLike(String city);
    List<User> findByIdGreaterThan(Integer id);
    List<User> findAllByOrderByIdAsc();

}
