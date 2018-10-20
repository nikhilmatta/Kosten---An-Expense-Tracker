package com.symbiosis.nikhilmatta.expensetracker;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by nikhilmatta on 13/04/18.
 */

public class addE implements Serializable {

    public Double amount;
    public String note;
    //String date;


    addE() {

        //Default Constructor

    }

    public addE(Double amount,String note) {

        this.amount=amount;

        this.note=note;

        //this.date=date;

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
