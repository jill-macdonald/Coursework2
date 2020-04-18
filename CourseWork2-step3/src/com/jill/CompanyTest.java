package com.jill;

import static junit.framework.TestCase.assertEquals;

public class CompanyTest {

    //test class for step 3
    private static Company testCompany = new Company("Test Company");


    //set the environment
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testCompany = new Company("Test Company");
    }

    //test add projects
    @org.junit.jupiter.api.Test
    void addProject() {
        Project testProject = new Project("Test Project");
        testCompany.addProject(testProject); //add project
        assertEquals(testProject, testCompany.findProjectByTitle("Test Project"));
    }

    //test add team member to project
    @org.junit.jupiter.api.Test
    void addTeamMemberToProject() {
        Project testProject = new Project("Test Project");
        testCompany.addProject(testProject);
        TeamMember teamMember1 = new TeamMember("Team Member 1", 1,23);
        TeamMember teamMember2 = new TeamMember("Team Member 2", 2,27);
        TeamMember teamMember3 = new TeamMember("Team Member 3", 3,30);
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember1); //add team member to project
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember2);
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember3);
        assertEquals(teamMember1, testCompany.findProjectByTitle("Test Project").getTeamMembers().get(0));
        assertEquals(teamMember2, testCompany.findProjectByTitle("Test Project").getTeamMembers().get(1));
        assertEquals(teamMember3, testCompany.findProjectByTitle("Test Project").getTeamMembers().get(2));
    }

    //test remove team member from project
    @org.junit.jupiter.api.Test
    void removeTeamMemberFromProject() {
        Project testProject = new Project("Test Project");
        testCompany.addProject(testProject);
        TeamMember teamMember1 = new TeamMember("Team Member 1", 1, 23);
        TeamMember teamMember2 = new TeamMember("Team Member 2", 2, 27);
        TeamMember teamMember3 = new TeamMember("Team Member 3", 3, 30);
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember1);
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember2);
        testCompany.addTeamMemberToProject(testCompany.findProjectByTitle("Test Project"), teamMember3);
        testCompany.removeTeamMemberFromProject(testProject, teamMember2);  //remove team member 2
        assertEquals(teamMember1, testCompany.findProjectByTitle("Test Project").getTeamMembers().get(0));
        assertEquals(teamMember3, testCompany.findProjectByTitle("Test Project").getTeamMembers().get(1)); // should be at 1, since team member 2 was removed
    }

    //test find project by title
    @org.junit.jupiter.api.Test
    void findProjectByTitle() {
        Project testProject1 = new Project("Test Project 1");
        Project testProject2 = new Project("Test Project 2");
        Project testProject3 = new Project("Test Project 3");
        testCompany.addProject(testProject1); //add project
        testCompany.addProject(testProject2);
        testCompany.addProject(testProject3);
        assertEquals(testProject1, testCompany.findProjectByTitle("Test Project 1")); //display project
        assertEquals(testProject2, testCompany.findProjectByTitle("Test Project 2"));
        assertEquals(testProject3, testCompany.findProjectByTitle("Test Project 3"));
    }
}
