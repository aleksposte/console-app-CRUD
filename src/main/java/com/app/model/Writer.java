package com.app.model;

import com.app.poststatus.WriterStatus;

import java.util.ArrayList;
import java.util.List;

public class Writer {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private WriterStatus writerStatus;


    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public List<Post> getPosts() { return posts; }

    public void setName(String firstName, String lastName, WriterStatus writerStatus, List<Post> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writerStatus = writerStatus;
        this.posts = posts;
    }

    public void addPostToWriter(Post post) {
        posts = (posts == null) ? new ArrayList<>() : posts;
        posts.add(post);
    }
}
