package com.view;

import com.controller.TeamMemberController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamMemberTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TeamMemberController teamMemberController = new TeamMemberController();
        int userInput;

        do {
            //menu
            System.out.println("1. Add a new team member");
            System.out.println("2. Find and display a team member");
            System.out.println("3. Remove a team member");
            System.out.println("4. Display all team members");
            System.out.println("0. Quit");

            //validate user input
            try {
                userInput = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {

                scan.nextLine();
                userInput = -1;
            }

            //switch menu
            switch (userInput) {
                case 0:
                    userInput = teamMemberController.quit();
                    break;

                case 1:
                    System.out.println("\n" + teamMemberController.addTeamMember());
                    break;
                case 2:

                    System.out.println("\n" + teamMemberController.findTeamMember());
                    break;
                case 3:
                    System.out.println("\n" + teamMemberController.removeTeamMember());
                    break;
                case 4:
                    teamMemberController.displayAllTeamMembers();
                    break;
                default:
                    System.out.println("-- Please Make another selection --");
                    break;
            }
        } while (userInput != 0);
    }

}