package com.model;

import java.time.LocalDate;

public class Project {

    //company variables
    private String title;
    private LocalDate expectedStartDate;
    private LocalDate expectedEndDate;


    //company constructor, setters and getters
    public Project(String title, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.expectedStartDate = startDate;
        this.expectedEndDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getExpectedStartDate() {
        return expectedStartDate;
    }


    public LocalDate getExpectedEndDate() {
        return expectedEndDate;
    }


}