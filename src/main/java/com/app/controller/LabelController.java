package com.app.controller;

import com.app.model.Label;
import com.app.poststatus.LabelStatus;
import com.app.repository.LabelRepository;
import com.app.repository.gson.GsonLabelRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository = new GsonLabelRepositoryImpl();

    public Label create(String name, LabelStatus labelStatus) throws IOException {
        Label label = new Label();
        label.setName(name, labelStatus);

        return labelRepository.save(label);
    }

    public Label read(Integer id) {
        return labelRepository.getById(id);
    }

    public Label update(Integer id, String name, LabelStatus labelStatus) throws IOException {
        Label label = new Label();
        label.setName(name, labelStatus);
        label.setId(id);

        return labelRepository.update(label);
    }

    public void delete(Integer id) throws IOException {
        labelRepository.deleteById(id);
    }

    public List<Label> getAll() {
        return labelRepository.getAll();
    }
}
