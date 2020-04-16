package com.example.javaharkka;

import java.io.Serializable;

public class EntryItem implements Serializable {

    private String mtechName;
    private int mnumber;

    public EntryItem(String techName, int number){
        mtechName = techName;
        mnumber = number;
    }

    public EntryItem() {
    }

    public String getTechName() {
        return mtechName;
    }

    public int getNumber() {
        return mnumber;
    }

    public void changeText(String text){
        mtechName = text;
    }



    public void setMnumber(int mnumber) {
        this.mnumber = mnumber;
    }
}
