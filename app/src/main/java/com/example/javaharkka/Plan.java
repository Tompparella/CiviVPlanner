package com.example.javaharkka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plan implements Serializable {

    String orientation;
    List techOrder = new ArrayList();

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void addTech(String tech) {
        techOrder.add(tech);
    }

    public void printTechs() {
        for (int i = 0; i < techOrder.size(); i++) {
            System.out.println(techOrder.get(i));
        }
    }
    public int getSize(){
        return techOrder.size();
    }
}
