package com.jill;

public class Company {
    public String projectTitle;

    //binary tree to store projects and team members
    private BinaryTree<Project> projects = new BinaryTree<>();

    //constructor
    public Company(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    //add a project to system
    public void addProject(Project p) {
        if (this.projects.add(p))
            System.out.println(p.getTitle() + " added");
        else System.out.println("Project already in system");
    }

    //add team member to project
    public void addTeamMemberToProject(Project project, TeamMember teamMember) {
        project.addTeamMember(teamMember);
    }

    //find and display project
    public void findAndDisplayByTitle(String s) {
        Project p = findProjectByTitle(s);
        System.out.println(p != null ? ("Title\t\t\t\t\t Members \n" + p.toString()) : "Project " + s + " not found");
    }

    public Project findProjectByTitle(String s) {
        return projects.find(new Project(s));
    }

    //display all projects in system
    public void displayAllProjects() {
        String s = projects.toString();
        if (s != null) System.out.println("Title \t\t\t\t\t Member \n" + s);
        else System.out.println("No Projects");
    }

    //remove team member from project
    public void removeTeamMemberFromProject(Project project, TeamMember teamMember) {
        project.removeTeamMember(teamMember);
    }

    //remove a project from system
    public void removeProject(Project p) {
        this.projects.remove(p);
    }

    //display number of team members in project
    public void displayMemberNumbersForAllProjects() {
        System.out.println("Title \t\t\t\t\t Members");
        projects.inOrder(new BinaryTreeRun<Project>() {
            @Override
            public void run() {
                System.out.println(this.getValue().getTitle() + "\t\t\t\t\t " + this.getValue().getTeamSize());
            }
        });
    }

}

