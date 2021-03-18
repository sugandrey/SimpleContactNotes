package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                //;
                case 1:
                    mobilePhone.printContactsList();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistName();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add new contact.");
        System.out.println("\t 3 - To update existing contact. ");
        System.out.println("\t 4 - To remove contact from list.");
        System.out.println("\t 5 - To search for contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addNewContact() {
        System.out.print("Add name please ");
        String name = scanner.nextLine();
        if (!mobilePhone.existInList(name)) {
            mobilePhone.addNamesToArray(name);
            System.out.print("Add phone number please ");
            String number = scanner.nextLine();
            mobilePhone.addNumbersToArray(number);
        } else {
            System.out.println("This name already exists");
        }
    }

    public static void updateExistName() {
        int answer = 0;
        System.out.println("Do you need to change name? 1 - Yes, 2 - No ");
        answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 1) {
            System.out.println("Enter current name please");
            String existName = scanner.nextLine();
            if (mobilePhone.existInList(existName)) {
                System.out.println("Enter new name please");
                String newName = scanner.nextLine();
                mobilePhone.modifyName(existName, newName);
            } else System.out.println("This name doesn't exist");
        } else if (answer == 2) {
            System.out.println("Do you need to change number? 1 - Yes, 2 - No ");
            answer = scanner.nextInt();
            scanner.nextLine();
            if (answer == 1) {
                System.out.println("Enter current name please");
                String existName = scanner.nextLine();
                if (mobilePhone.existInList(existName)) {
                    System.out.println("Enter new number please");
                    String newNumber = scanner.nextLine();
                    mobilePhone.modifyNumber(existName, newNumber);
                } else System.out.println("This name doesn't exist");
            }
        }

    }
    public static void removeContact() {
        System.out.print("Enter contact's name: ");
        String name = scanner.nextLine();
        if (mobilePhone.existInList(name)) {
            mobilePhone.removeContact(name);
        }
        else {
            System.out.println("This name doesn't exist");
        }
    }
    public static void searchContact() {
        System.out.print("Name to search for: ");
        String name = scanner.nextLine();
        if (mobilePhone.existInList(name)) {
            mobilePhone.printContact(name);
        } else {
            System.out.println(name + " is not in your contact list");
        }
    }
}
