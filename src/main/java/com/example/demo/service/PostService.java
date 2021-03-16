package com.example.demo.service;

import com.example.demo.controller.OuterDataController;
import com.example.demo.dao.PostRepository;
import com.example.demo.entity.Post;
import com.example.demo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public PostService(PostRepository postRepository, RestTemplate restTemplate) {
        this.postRepository = postRepository;
        this.restTemplate = restTemplate;
    }

    public List<Post> findByUserId(Integer id,Pageable pageable)
    {
        return postRepository.findByUserId(id,pageable);
    }

    public List<Post> findByUserId(Integer id)
    {
        return postRepository.findByUserId(id);
    }

    public List<Post> findPostTitleLike(Integer id, String title)
    {
        return postRepository.findByUserIdAndTitleContains(id,title);
    }

    public List<Post> findPostTitleLike(Integer id, String title,Pageable pageable)
    {
        return postRepository.findByUserIdAndTitleContains(id,title,pageable);
    }

    public boolean save(Post post) {
        if(post != null)
        {
            postRepository.save(post);
            return true;
        }
        else
            return false;

    }

    public Post show(Integer id) {
        Post post = postRepository.findById(id).get();

        return post;
    }
    public Iterable<Post> index() {
        return postRepository.findAll();
    }
    public Integer count() {
        return (int) postRepository.count();
    }
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }

    public void saveOuterPost() throws URISyntaxException {
        OuterDataController outerPost = new OuterDataController(restTemplate);
        for (Post post : outerPost.getAllOuterPosts())
        {
            this.save(post);
        }
    }



}
