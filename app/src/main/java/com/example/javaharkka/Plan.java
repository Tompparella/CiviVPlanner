package com.example.javaharkka;

import java.io.Serializable;
import java.util.ArrayList;

public class Plan implements Serializable {

    public String orientation,description,planName,creator,creatorId;
    public ArrayList<EntryItem> techOrder = new ArrayList();
    public ArrayList<PolicyItem> policyOrder = new ArrayList();


    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void addTech(EntryItem tech) {
        techOrder.add(tech);
    }

    public void addPolicy(PolicyItem item){
        policyOrder.add(item);
    }

    public void printPolicies(){
        for (int i = 0; i < policyOrder.size(); i++){
            System.out.println(policyOrder.get(i).getPolicyName());
        }
    }

    public void printTechs() {
        for (int i = 0; i < techOrder.size(); i++) {
            System.out.println(techOrder.get(i).getTechName());
        }
    }

    public String getTech(int i){
        return String.valueOf(techOrder.get(i));
    }

}
