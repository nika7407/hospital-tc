package com.solvd.hospitaltc.drug;

public class Painkiller extends Drug {

    private int power;

    public Painkiller(String name, int power) {
        super(name);
        this.power = power;
        setAprroved(true);
    }
}
