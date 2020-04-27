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

    public void changeText(String text) {
        techName = text;
    }
}
