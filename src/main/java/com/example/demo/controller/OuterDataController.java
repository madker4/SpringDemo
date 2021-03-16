package com.example.demo.controller;

import com.example.demo.dao.PostMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Gender;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;


import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OuterDataController {
    private final String URL_USERS = "http://jsonplaceholder.typicode.com/users";
    private final String URL_POSTS = "http://jsonplaceholder.typicode.com/posts";

    private RestTemplate restTemplate;

    @Autowired
    public OuterDataController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllOuterUsers() throws URISyntaxException {

        URI uri = new URI(URL_USERS);

        UserMapper[] mapper = restTemplate.getForObject(uri, UserMapper[].class);
        ArrayList<User> users = new ArrayList<>();

        for (UserMapper um : mapper)
        {
            User user = um.getUser();
            users.add(user);
        }

        return users;

    }

    public User getOuterUser(Integer id) throws URISyntaxException {
        final String requestUrl = URL_USERS + "/" + id.toString();

        URI uri = new URI(requestUrl);

        User result = restTemplate.getForObject(uri, UserMapper.class).getUser();

        return result;

    }

    public List<Post> getAllOuterPosts() throws URISyntaxException {

        URI uri = new URI(URL_POSTS);

        PostMapper[] mapper = restTemplate.getForObject(uri, PostMapper[].class);
        ArrayList<Post> posts = new ArrayList<>();

        for (PostMapper pm : mapper)
        {
            Post post = pm.getPost();
            posts.add(post);
        }

        return posts;

    }

    public Post getOuterPost(Integer id) throws URISyntaxException {
        final String requestUrl = URL_POSTS + "/" + id.toString();

        URI uri = new URI(requestUrl);

        Post result = restTemplate.getForObject(uri, PostMapper.class).getPost();

        return result;

    }
}
