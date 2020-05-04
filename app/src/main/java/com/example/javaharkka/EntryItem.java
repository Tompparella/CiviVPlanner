/*
CiviVPlanner; Android Studio; Tommi Kunnari; EntryItem.class;

A class that stores a technology entry's information and is later
stored to the Plan class as a list. All variables and methods are
declared public for Firebase to be able to process them.
*/

package com.example.javaharkka;

import java.io.Serializable;

public class EntryItem implements Serializable {

    private String techName;
    private int number;

    public EntryItem(String name, int num) {
        techName = name;
        number = num;
    }

    public EntryItem() {
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTechName() {
        return techName;
    }

    public int getNumber() {
        return number;
    }

}
