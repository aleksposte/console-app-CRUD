package com.app.repository.gson;

import com.app.model.Post;
import com.app.model.Writer;
import com.app.poststatus.PostStatus;
import com.app.poststatus.WriterStatus;
import com.app.repository.PostRepository;
import com.app.repository.WriterRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String FILE_PATH = "src/main/resources/writers.json";
    private final Gson gson = new Gson();

    private void writeWritersToFile(List<Writer> writers) {
        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(writers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Writer> getAllWriters() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Writer>>(){}.getType();
            List<Writer> writers = gson.fromJson(reader, type);

            if (writers == null) {
                 writers = new ArrayList<>();
             }

            return writers;
        } catch (IOException e) {
            System.out.println("Err: " + e);
            return Collections.emptyList();
        }
    }

    private Integer generateId(List<Writer> writers) {
        return writers.stream().mapToInt(Writer::getId).max().orElse(0) + 1;
    }

    @Override
    public List<Writer> getAll() {
        return getAllWriters();
    }

    @Override
    public Writer getById(Integer id) {
        return getAllWriters().stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Writer save(Writer writerToSave) throws IOException {
        List<Writer> writer = getAllWriters();

        writerToSave.setId(generateId(writer));
        writer.add(writerToSave);
        writeWritersToFile(writer);

        return writerToSave;
    }

    @Override
    public Writer update(Writer writerToUpdate) throws IOException {
        List<Writer> writers = getAllWriters()
                .stream().map(existingPost -> {
                    if(existingPost.getId().equals(writerToUpdate.getId())) {
                        return writerToUpdate;
                    }
                    return existingPost;
                }).toList();
        writeWritersToFile(writers);
        return writerToUpdate;
    }

    @Override
    public void deleteById(Integer id) throws IOException {
        List<Writer> writers = getAllWriters()
                .stream().map(existingPost -> {
                    if(existingPost.getId().equals(id)) {
                        existingPost.setName(existingPost.getFirstName(), existingPost.getLastName(), WriterStatus.DELETED, existingPost.getPosts());
                    }
                    return existingPost;
                }).toList();
        writeWritersToFile(writers);
    }
}
