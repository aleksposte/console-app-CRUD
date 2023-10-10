package com.app.repository.gson;

import com.app.model.Label;
import com.app.poststatus.LabelStatus;
import com.app.repository.LabelRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String FILE_PATH = "src/main/resources/labels.json";
    private final Gson gson = new Gson();

    private void writeLabelsToFile(List<Label> labels) {
        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(labels, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Label> getAllLabels() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Label>>(){}.getType();
            List<Label> labels = gson.fromJson(reader, type);

            return labels;
        } catch (IOException e) {
            System.out.println("Err: " + e);
            return Collections.emptyList();
        }
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
        return getAllLabels().stream()
                .filter(label -> label.getId().equals(id))
                .findFirst()
                .orElse(null);
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
        List<Label> labels = getAllLabels()
                .stream().map(existingLabel -> {
                    if(existingLabel.getId().equals(id)) {
                        existingLabel.setName(existingLabel.getName(), LabelStatus.DELETED);
                    }
                    return existingLabel;
                }).toList();
        writeLabelsToFile(labels);
    }
}
