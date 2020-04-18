package com.controller;

import com.model.TeamMember;
import java.util.LinkedList;
import java.util.Scanner;


public class TeamMemberController {

    private TeamMember teamMember;

    public TeamMemberController() {
        String name = null;
        this.teamMember = new TeamMember(name);
    }

    Scanner scan = new Scanner(System.in);

    public String addTeamMember() {
        System.out.println("To go back press 0");
        String name = null;
        boolean keepLooping = true;

        //get team member linked list
        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();


        //user enters name, checks no other exists
        while (keepLooping) {
            System.out.println("Enter team member name");
            name = scan.nextLine();
            if (name.equals("0")) {
                return "team member not added";
            }

            if (!this.checkIfTeamMemberNameExists(name)) {
                keepLooping = false;
            } else {
                System.out.println("Team Member already exists");
            }
        }


        //add team member to linked list
        teamMembers.add(new TeamMember(name));

        teamMember.setTeamMembers(teamMembers);

        //prints 'added' if successful
        return "Name: " + name + "\n --Added--";
    }

    public String findTeamMember() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();

        if (teamMembers.isEmpty()) {
            return "No team members";     //if linked list is empty, tells user no team members
        }

        System.out.println("Enter team member name");
        String name = scan.nextLine();


        for (TeamMember t : teamMembers) {
            if (t.getName().equals(name)) {
                return "Name: " + t.getName();      //prints team member
            }
        }
        return "Team member not found";     //if team member's not in linked list
    }


        public String removeTeamMember() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();
        System.out.println("Enter name of team member to remove");
        String name = scan.nextLine();

            if (name.equals("0")) {
            return "No team member removed";
        }

        //check team member names against the user input one
            for (TeamMember t : teamMembers) {
                if (t.getName().equals(name)) {

                    System.out.println("Team member removed");  //removed
                }
            }
            return "Team member not found";     //not found

        }

    public void displayAllTeamMembers() {

        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();
        if (teamMembers.isEmpty()) {
            System.out.println("Company has not added any team members");   //linked list has no team members
            return;
        }

        System.out.format(" Name%n");

        for (TeamMember t : teamMembers) {
            System.out.println(t.getName());        //prints all team members in linked list
        }
    }


    public int quit() {
        System.out.println("Are you sure you want to quit? y/n");   //user confirms quit
        String userResponse = scan.nextLine();
        boolean loop = true;

        while (loop) {
            if (userResponse.equalsIgnoreCase("y")) {
                System.out.println("Program ending");
                return 0;
            } else if (userResponse.equalsIgnoreCase("n"))
                return 5;
        }
        return 0;
    }


    public boolean checkIfTeamMemberNameExists(String name) {

        //get team member linked list
        LinkedList<TeamMember> teamMembers = teamMember.getTeamMembers();

        //if a team member with the same name already exists return true
        if (!teamMembers.isEmpty()) {
            for (TeamMember t : teamMembers) {
                if (t.getTeamMembers().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}