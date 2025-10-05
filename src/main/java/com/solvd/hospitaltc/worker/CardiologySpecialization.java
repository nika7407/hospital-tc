package com.solvd.hospitaltc.worker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CardiologySpecialization implements Spetialization {

    private static final Logger log = LogManager.getLogger(CardiologySpecialization.class);

    @Override
    public void printSpetialization() {
        log.info("This doctor specializes in cardiology");
    }
}
