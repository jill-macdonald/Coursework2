package com.jill;

import java.util.ArrayList;

public class Project implements Comparable<Project> {
    private String title;

    //array list to store team members
    private ArrayList<TeamMember> teamMembers = new ArrayList<>();

    public Project(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        try {
            return this.title.equals(((Project) o).title);
        } catch (Exception e) {
            return false;
        }
    }

    //display team members and title
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(title);
        if (teamMembers.isEmpty()) {
            s.append("\t\t\t\t\t\t No Members");
        } else {
            s.append("\t\t\t\t\t");
            for (TeamMember t : teamMembers) {
                s.append(" ").append(t.getName()).append("\n\t\t\t\t\t\t");
            }
        }
        return s.toString();
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    //add team member
    public void addTeamMember(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
    }

    //remove a team member
    public void removeTeamMember(TeamMember teamMember) {
        if (this.teamMembers.remove(teamMember)) {
            System.out.println(teamMember.getName() + " removed");
        } else {
            System.out.println(teamMember.getName() + " not found");
        }
    }

    //display number of members in each project
    public int getTeamSize() {
        return this.teamMembers.size();
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return this.teamMembers;
    }

    public String getTitle() {
        return title;
    }

}

