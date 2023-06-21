package com.evenements.evenements.Entities;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Evenment> evenments;

    //initializer constructor
    public Calendar(){}

    public Calendar(List<Evenment> evenments){
        this.evenments = evenments;
    }

    public List<Evenment> getEvenments() {
        return evenments;
    }

    public void setEvenments(List<Evenment> evenments) {
        this.evenments = evenments;
    }
}
