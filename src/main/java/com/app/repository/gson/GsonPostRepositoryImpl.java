package com.app.repository.gson;

import com.app.model.Label;
import com.app.model.Post;
import com.app.poststatus.LabelStatus;
import com.app.poststatus.PostStatus;
import com.app.repository.LabelRepository;
import com.app.repository.PostRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {
    private final String FILE_PATH = "src/main/resources/posts.json";
    private final Gson gson = new Gson();

    private void writePostsToFile(List<Post> posts) {
        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Post> getAllPosts() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Post>>(){}.getType();
            List<Post> posts = gson.fromJson(reader, type);

            if (posts == null) {
                 posts = new ArrayList<>();
             }

            return posts;
        } catch (IOException e) {
            System.out.println("Err: " + e);
            return Collections.emptyList();
        }
    }

    private Integer generateId(List<Post> posts) {
        return posts.stream().mapToInt(Post::getId).max().orElse(0) + 1;
    }

    @Override
    public List<Post> getAll() {
        return getAllPosts();
    }

    @Override
    public Post getById(Integer id) {
        return getAllPosts().stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post postToSave) {
        List<Post> posts = getAllPosts();

        postToSave.setId(generateId(posts));
        posts.add(postToSave);
        writePostsToFile(posts);

        return postToSave;
    }

    @Override
    public Post update(Post postToUpdate) {
        List<Post> posts = getAllPosts()
                .stream().map(existingPost -> {
                    if(existingPost.getId().equals(postToUpdate.getId())) {
                        return postToUpdate;
                    }
                    return existingPost;
                }).toList();
        writePostsToFile(posts);
        return postToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> posts = getAllPosts()
                .stream().map(existingPost -> {
                    if(existingPost.getId().equals(id)) {
                        existingPost.setName(existingPost.getName(), existingPost.getCreated(), existingPost.getUpdated(),  PostStatus.DELETED, existingPost.getLabels());
                    }
                    return existingPost;
                }).toList();
        writePostsToFile(posts);
    }
}
