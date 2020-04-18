package com.model;

import java.util.LinkedList;

public class TeamMember {

    //linked list to store team members
    private LinkedList<TeamMember> teamMembers;

    public LinkedList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(LinkedList<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    private String name;
    public TeamMember(String name) {
        this.name = name;
        this.teamMembers = new LinkedList<>();
    }
    public String getName() {
        return name;
    }
}
