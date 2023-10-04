package com.app.repository.gson;

import com.app.model.Label;
import com.app.repository.LabelRepository;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {

    private final Gson GSON = new Gson();
    private final String FILE_PATH = "src/main/java/resources/labels.json";


    private List<Label> getAllLabels() {
        return new ArrayList<>();
    }

    private void writeLabelsToFile(List<Label> labels) throws IOException {
        String json = GSON.toJson(labels);
        //TODO: write string to file
        FileWriter writer = new FileWriter(FILE_PATH);
        GSON.toJson(labels);
    }

    private Integer generateId(List<Label> labels) {
        return labels.stream().mapToInt(Label::getId).max().orElse(0) + 1;
    }

    @Override
    public List<Label> getAll() {
        return getAllLabels();
    }

    @Override
    public Label getById(Integer id) {
        return getAllLabels()
                .stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Label save(Label labelToSave) throws IOException {
        List<Label> labels = getAllLabels();

        labelToSave.setId(generateId(labels));
        labels.add(labelToSave);
        writeLabelsToFile(labels);
        return labelToSave;
    }

    @Override
    public Label update(Label labelToUpdate) throws IOException {
        List<Label> labels = getAllLabels()
                .stream().map(existingLabel -> {
                    if(existingLabel.getId().equals(labelToUpdate.getId())) {
                        return labelToUpdate;
                    }

                    return existingLabel;
                }).toList();
        writeLabelsToFile(labels);
        return labelToUpdate;
    }

    @Override
    public void deleteById(Integer id) throws IOException {
        List<Label> labels = getAllLabels();
        labels.removeIf(label -> label.getId().equals(id));

        writeLabelsToFile(labels);
    }
}
