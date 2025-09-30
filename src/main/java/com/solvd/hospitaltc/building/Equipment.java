package com.solvd.hospitaltc.building;

public class Equipment {

    protected boolean inUse;
    protected String name;

    public boolean InUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
