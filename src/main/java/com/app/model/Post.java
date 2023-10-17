package com.app.model;

import com.app.poststatus.PostStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Integer id;
    private String name;
    private Date created;
    private Date updated;
    private List<Label> labels;
    private PostStatus postStatus;


    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public Date getCreated() { return created; }

    public Date getUpdated() { return updated; }

    public List<Label> getLabels() { return labels; }

    public void setName(String name, Date created, Date updated, PostStatus postStatus, List<Label> labels) {
        this.name = name;
        this.postStatus = postStatus;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public void addLabelToPost(Label label) {
        if (labels == null) {
            labels = new ArrayList<>();
        }

        labels.add(label);
    }
}
