package com.jill;

import java.util.Scanner;

public class Main {
    private static Company company = new Company("Test Company");

    public static void main(String[] args) {
        //switch menu
        while (true) {
            switch (menu("Main Menu",
                    "Add Project",
                    "Add Team Member",
                    "Remove Team Member",
                    "Remove Project",
                    "Display All Team Members For Project",
                    "Display All Projects",
                    "Display Number of Team Members in Each Project")) {

                case 0:
                    System.exit(0);
                case 1:
                    company.addProject(new Project(getString("Enter project title")));
                    break;
                case 2:
                    company.addTeamMemberToProject(
                            company.findProjectByTitle(getString("Enter title of project to add team member to")),
                            new TeamMember(getString("Enter team member name"), getInt("Enter employee number"), getInt("Enter team member age")));
                    break;
                case 3:
                    company.removeTeamMemberFromProject(
                            company.findProjectByTitle(getString("Enter title of project to remove team member from")),
                            new TeamMember(getString("Enter team member name"), 1, 23));
                    break;
                case 4:
                    Project project = company.findProjectByTitle(getString("Enter title of project to remove"));
                    if (project != null) {
                        company.removeProject(project);
                        System.out.println(project.getTitle() + " removed");
                    } else System.out.println("Project not found");
                    break;
                case 5:
                    company.findAndDisplayByTitle(getString("Enter project title"));
                    break;
                case 6:
                    company.displayAllProjects();
                    break;
                case 7:
                    company.displayMemberNumbersForAllProjects();
                    break;
            }
        }
    }

    private static int menu(String prompt, String... options) {
        System.out.println("\t" + prompt);
        int q = 1;
        for (String s : options) {
            System.out.println(q++ + ") " + s);
        }
        System.out.print("0) Quit\n> ");

        //validate input
        String response = new Scanner(System.in).nextLine();
        try {
            int responseInt = Integer.parseInt(response);
            if (responseInt >= 0 || responseInt <= q) return responseInt;
            else throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid input");
            return menu(prompt, options);
        }
    }

    private static String getString(String prompt) {
        System.out.print(prompt + "\n> ");
        return new Scanner(System.in).nextLine();
    }

    private static int getInt(String prompt) {
        try {
            return Integer.parseInt(getString(prompt));
        } catch (Exception e) {
            System.out.println("Enter an integer");
            return getInt(prompt);
        }
    }
}
