package com.company;

import java.util.ArrayList;

public class MobilePhone extends Contacts {

    private ArrayList<String> namesList = new ArrayList<>();
    private ArrayList<String> numberList = new ArrayList<>();

//    public MobilePhone(String name, String phoneNumber) {
//        super(name, phoneNumber);
//
//    }
    public void addNamesToArray(String name) {
        namesList.add(name);
    }

    public void addNumbersToArray(String number) {
        numberList.add(number);
    }

    public void printContactsList() {
        System.out.println("You have " + namesList.size() + " contacts in the List");
        for (int i = 0; i < namesList.size(); i++) {
            System.out.println((i + 1) + ". Name is " + namesList.get(i) + " and number is " + numberList.get(i));

        }
    }

    private int findName(String searchName) {
        return namesList.indexOf(searchName);
    }

    public boolean existInList(String searchName) {
        int measurement = findName(searchName);
        if (measurement >= 0) {
            return true;
        }
        return false;
    }

    private void modifyName(int index, String newName) {
        namesList.set(index, newName);
    }

    private void modifyNumber(int index, String newNumber) {
        numberList.set(index, newNumber);
    }

    public void modifyName(String currentName, String newName) {
        int index = findName(currentName);
        if (index >= 0) {
            modifyName(index, newName);
        }
    }

    public void modifyNumber(String currentName, String newNumber) {
        int index = findName(currentName);
        if (index >= 0) {
            modifyNumber(index, newNumber);
        }

    }

    private void removeContact(int index) {
        namesList.remove(index);
        numberList.remove(index);
    }

    public void removeContact(String name) {
        int index = findName(name);
        if (index >= 0) {
            removeContact(index);
        }

    }
    public void printContact(String searchName) {
        int index = findName(searchName);
        if (index >= 0) {
            System.out.println(namesList.get(index) + " " + numberList.get(index));
        }
    }
}

