package com.controller;

import com.model.Company;
import com.model.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class CompanyController {
    private Company company;

    public CompanyController() {
        this.company = new Company();
    }

    Scanner scan = new Scanner(System.in);

    public String addProject() {
        System.out.println("To go back press 0");
        String title = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        boolean keepLooping = true;

        //get project ArrayList from Company
        ArrayList<Project> projects = company.getProjects();

        //set date format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");

        //user enters project name, checks no other exists
        while (keepLooping) {
            System.out.println("Enter project name");
            title = scan.nextLine();
            if (title.equals("0")) {
                return "project not added";
            }

            if (!this.checkIfProjectNameExists(title)) {
                keepLooping = false;
            } else {
                System.out.println("Project name already exists");
            }
        }

        //user enters start date
        keepLooping = true;
        while (keepLooping) {

            System.out.println("Enter start date");
            System.out.println("dd mm yyyy");

            //validate start date
            try {

                String sDate = scan.nextLine();

                if (sDate.equals("0")) {
                    return "project not added";
                }

                startDate = LocalDate.parse(sDate, dateTimeFormatter);
                keepLooping = false;


            } catch (DateTimeParseException e) {
                System.out.println("Problem with date format");
                System.out.println("");
                keepLooping = true;
            }
        }

        //user enter end date
        keepLooping = true;
        while (keepLooping) {

            System.out.println("Enter expected end date");
            System.out.println("dd mm yyyy");

            //Validate end date
            try {

                String eDate = scan.nextLine();


                if (eDate.equals("0")) {
                    return "project not added";
                }

                endDate = LocalDate.parse(eDate, dateTimeFormatter);
                keepLooping = false;


            } catch (DateTimeParseException e) {
                System.out.println("Problem with date format");
                keepLooping = true;
            }
        }

        //add project to array list
        projects.add(new Project(title, startDate, endDate));

        //update array list
        company.setProjects(projects);

        //returns true when a project has been successfully added
        return "Project Title: " + title + "\n StartDate: " + startDate + "\nEndDate: " + endDate + "\n--Added--";
    }

    public String findProject() {

        ArrayList<Project> projects = company.getProjects();

        if (projects.isEmpty()) {
            return "No Projects"; //array list empty
        }
        System.out.println("Enter  projects  name");
        String projectName = scan.nextLine();


        for (Project p : projects) {
            if (p.getTitle().equals(projectName)) {
                return "ProjectName: " + p.getTitle() + " \nStartDate: "
                        + p.getExpectedStartDate() + "\n EndDate: " + p.getExpectedEndDate();
            }
        }
        return "Project with this name not found";
    }

    public String removeProject() {

        ArrayList<Project> projects = company.getProjects();
        System.out.println("Enter name of project to remove");
        String projectToRemove = scan.nextLine();
        boolean removed = false;

        if (projectToRemove.equals("0")) {
            return "No project removed";
        }

        //compare input name to array list names
        for (Project p : projects) {
            if (p.getTitle().equals(projectToRemove)) {
                projects.remove(p);
                removed = true;
            }
        }
        if (removed) {
            company.setProjects(projects);
        } else
            return "Project not found";

        return projectToRemove + " Removed";
    }

    public void displayAll() {

        ArrayList<Project> projects = company.getProjects();
        if (projects.isEmpty()) {
            System.out.println("No Projects");  //array list is empty
            return;
        }


        System.out.format(" Name               Start             End        %n");

        for (Project p : projects) {


            System.out.println(p.getTitle() + "         " + p.getExpectedStartDate() + "    " + p.getExpectedEndDate());
        }


    }


    public int quit() {
        System.out.println("Are you sure you want to quit? y/n");       //user confirms quit
        String userResponse = scan.nextLine();

        while (true) {
            if (userResponse.equalsIgnoreCase("y")) {
                System.out.println("Program ending");
                return 0;
            } else if (userResponse.equalsIgnoreCase("n"))
                return 5;
        }
    }


    public boolean checkIfProjectNameExists(String projectName) {

        ArrayList<Project> projects = company.getProjects();
        //if a project with the same name already exists return true
        if (!projects.isEmpty()) {
            for (Project p : projects) {
                if (p.getTitle().equals(projectName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
