package com.example.demo.dao;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
//CrudRepository<Post, Integer>
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
    List<Post> findByUserId(Integer id, Sort sort, Pageable pageable);
    List<Post> findByUserId(Integer id);

    List<Post> findByUserIdAndTitleContains(Integer id, String title);
}
