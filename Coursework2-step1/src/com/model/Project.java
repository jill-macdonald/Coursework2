package com.model;

import java.time.LocalDate;

public class Project {

    public String getTitle() {
        return title;
    }

    public LocalDate getExpectedStartDate() {
        return expectedStartDate;
    }


    public LocalDate getExpectedEndDate() {
        return expectedEndDate;
    }


    private String title;
    private LocalDate expectedStartDate;
    private LocalDate expectedEndDate;


    public Project(String title, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.expectedStartDate = startDate;
        this.expectedEndDate = endDate;
    }

}