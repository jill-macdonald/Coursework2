package com.view;

import com.controller.CompanyController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompanyTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CompanyController companyController = new CompanyController();
        int userInput;

        //menu options
        do {

            System.out.println("1. Add a new project");
            System.out.println("2. Find and display a project");
            System.out.println("3. Remove a project");
            System.out.println("4. Display all projects");
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
                    userInput = companyController.quit();
                    break;

                case 1:
                    System.out.println("\n" + companyController.addProject());
                    break;
                case 2:

                    System.out.println("\n" + companyController.findProject());
                    break;
                case 3:
                    System.out.println("\n" + companyController.removeProject());
                    break;
                case 4:
                    companyController.displayAll();
                    break;
                default:
                    System.out.println("-- Please Make another selection --");

                    break;
            }
        } while (userInput != 0);
    }

}