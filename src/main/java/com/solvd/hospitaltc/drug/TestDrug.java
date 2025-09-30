package com.solvd.hospitaltc.drug;

public class TestDrug extends Drug {

    private String warnings;

    public TestDrug(String name, String warnings) {
        super(name);
        this.warnings = warnings;
    }
}
