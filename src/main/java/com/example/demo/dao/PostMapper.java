package com.example.demo.dao;

import com.example.demo.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "id",
        "title",
        "body",
})
public class PostMapper {
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PostMapper(Integer userId, Integer username, String title, String body) {
        this.userId = userId;
        this.id = username;
        this.title = title;
        this.body = body;
    }

    public PostMapper() {
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }
    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("body")
    public String getBody() {
        return body;
    }
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost()
    {
        Post post = new Post(this.id,this.userId,this.title,this.body);
        return post;
    }
}
