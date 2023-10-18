package com.app.controller;

import com.app.model.Post;
import com.app.model.Writer;
import com.app.poststatus.WriterStatus;
import com.app.repository.WriterRepository;
import com.app.repository.gson.GsonWriterRepositoryImpl;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository = new GsonWriterRepositoryImpl();

    public Writer create(String firstName, String lastName, WriterStatus writerStatus, List<Post> posts) {
        Writer writer = new Writer();

        writer.setName(firstName, lastName, writerStatus, posts);

        return writerRepository.save(writer);
    }

    public Writer read(Integer id) {
        return writerRepository.getById(id);
    }

    public Writer update(Integer id, String firstName, String lastName, WriterStatus writerStatus, List<Post> posts) {
        Writer writer = new Writer();
        writer.setName(firstName, lastName, writerStatus, posts);
        writer.setId(id);

        return writerRepository.update(writer);
    }

    public void delete(Integer id) {
        writerRepository.deleteById(id);
    }

    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    public Writer addPostToWriter(Integer id, Post post) {
        Writer writer = writerRepository.getById(id);
        writer.addPostToWriter(post);

        return writerRepository.update(writer);
    }

}
