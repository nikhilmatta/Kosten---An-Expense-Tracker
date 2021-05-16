package com.symbiosis.nikhilmatta.expensetracker;

import java.io.Serializable;

public class groupName implements Serializable{

    String name;

    groupName() {


    }

    public groupName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
