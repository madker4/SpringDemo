package com.example.demo.service;

import com.example.demo.controller.OuterDataController;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService{

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public List<User> findByCityLike(String city) {
        return userRepository.findByCityLike(city);
    }

    public List<User> findByIdGreaterThan(Integer id) {
        return userRepository.findByIdGreaterThan(id);
    }

    public boolean save(User user) {
        if(user != null)
        {
            userRepository.save(user);
            return true;
        }
        else
            return false;

    }

    public User show(Integer id) {
        User user = userRepository.findById(id).get();

        return user;
    }
    public Iterable<User> index() {
        return userRepository.findAllByOrderByIdAsc();
    }
    public Integer count() {
        return (int) userRepository.count();
    }
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void saveOuterUser() throws URISyntaxException {
        OuterDataController outerUser = new OuterDataController(restTemplate);
        for (User user : outerUser.getAllOuterUsers())
        {
            this.save(user);
        }
    }
}
