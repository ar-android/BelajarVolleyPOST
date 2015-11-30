package com.ocit.trainingapi.model;

/**
 * Created by ar-android on 30/11/2015.
 */
public class DisplayStatus {

    private int id;
    public String id_creator;
    public String name_creator;
    public String content;
    public String created;
    public String updated;
    public String image;

    public int getId() {
        return id;
    }

    public String getId_creator() {
        return id_creator;
    }

    public String getName_creator() {
        return name_creator;
    }

    public String getContent() {
        return content;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getImage() {
        return image;
    }
}
