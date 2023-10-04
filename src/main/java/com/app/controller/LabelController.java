package com.app.controller;

import com.app.model.Label;
import com.app.repository.LabelRepository;
import com.app.repository.gson.GsonLabelRepositoryImpl;
import com.app.view.LabelView;

import java.io.IOException;

public class LabelController {
    private final LabelRepository labelRepository = new GsonLabelRepositoryImpl();
//    public final LabelView labelView = new LabelView();
//    Label labelTest = new Label();

//    labelView.start();

    public void start() throws IOException {
        LabelView labelView = new LabelView();
        labelView.start();
    }


    public Label create(String name) throws IOException {
        Label label = new Label();
        label.setName(name);
        return labelRepository.save(label);
//        return null;
    }
}
