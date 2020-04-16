package com.example.javaharkka;

import java.io.Serializable;

public class PolicyItem implements Serializable {

    private String policyName;
    private int number;
    private int type; /* 1 = Tradition, 2 = Liberty, 3 = Honor, 4 = Piety, 5 = Patronage
                         6 = Aesthetics, 7 = Commerce, 8 = Exploration, 9 = Rationalism */

    public PolicyItem(String pName, int pnumber, int ptype){
        policyName = pName;
        number = pnumber;
        type = ptype;
    }

    public PolicyItem() {
    }

    public String getPolicyName() {
        return policyName;
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

}