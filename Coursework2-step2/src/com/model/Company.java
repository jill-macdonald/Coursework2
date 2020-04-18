package com.model;

import java.util.ArrayList;

public class Company {

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    private ArrayList<Project> projects;

    public Company() {
        this.projects = new ArrayList<>();

    }

}