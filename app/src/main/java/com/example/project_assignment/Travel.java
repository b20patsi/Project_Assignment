package com.example.project_assignment;

import com.google.gson.annotations.SerializedName;

public class Travel {
    private String id;
    private String name;
    private String company;
    private String location;
    @SerializedName("category")
    private String url;
    private int cost;

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public int getCost() {
        return cost;
    }
}