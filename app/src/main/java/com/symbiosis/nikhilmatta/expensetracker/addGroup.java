package com.symbiosis.nikhilmatta.expensetracker;

import java.io.Serializable;

/**
 * Created by nikhilmatta on 17/04/18.
 */

public class addGroup implements Serializable {

    public String name;
    public Double amount;
    public String note;

    addGroup() {


    }

    public addGroup(String name, Double amount, String note) {
        this.name = name;
        this.amount = amount;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


