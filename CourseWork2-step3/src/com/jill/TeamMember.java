package com.jill;

public class TeamMember implements Comparable<TeamMember> {

    private String name;
    private int employeeNo;
    private int age;

    //constructor
    public TeamMember(String name, int employeeNo, int age) {
        this.name = name;
        this.employeeNo = employeeNo;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        try {
            return this.name.equals(((TeamMember) o).name);
        } catch (Exception e) {
            return false;
        }
    }

    //display name, employeeNo and age of team member
    @Override
    public String toString() {
        return name + "\t\t " + employeeNo + "\t\t " + age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(TeamMember teamMember) {
        return this.name.compareTo(teamMember.name);
    }
}
