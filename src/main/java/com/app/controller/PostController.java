package com.app.controller;

import com.app.model.Label;
import com.app.model.Post;
import com.app.poststatus.PostStatus;
import com.app.repository.PostRepository;
import com.app.repository.gson.GsonPostRepositoryImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class PostController {
    private final PostRepository postRepository = new GsonPostRepositoryImpl();

    public Post create(String name, Date created, Date updated, PostStatus postStatus, List<Label> labels) throws IOException {
        Post post = new Post();
        post.setName(name, created, updated, postStatus, labels);

        return postRepository.save(post);
    }

    public Post read(Integer id) {
        return postRepository.getById(id);
    }

    public Post update(Integer id, String name, Date created, Date updated, PostStatus postStatus, List<Label> labels) throws IOException {
        Post post = new Post();
        post.setName(name, created, updated, postStatus, labels);
        post.setId(id);

        return postRepository.update(post);
    }

    public void delete(Integer id) throws IOException {
        postRepository.deleteById(id);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public Post addLabelToPost(Integer id, Label label) throws IOException {
        Post post = postRepository.getById(id);
        post.addLabelToPost(label);

        return postRepository.update(post);
    }
}
