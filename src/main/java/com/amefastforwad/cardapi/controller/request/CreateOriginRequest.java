package com.amefastforwad.cardapi.controller.request;

import com.amefastforwad.cardapi.model.Card;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class CreateOriginRequest {

    private String name;
    private String description;
    private String creator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "CreateCardRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", strength=" + creator +'\'' +
                '}';
    }
}
