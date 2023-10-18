package com.app.model;

import com.app.poststatus.LabelStatus;

public class Label {
    private Integer id;
    private String name;
    private LabelStatus labelStatus;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name,  LabelStatus labelStatus) {
        this.name = name;
        this.labelStatus = labelStatus;
    }

}
