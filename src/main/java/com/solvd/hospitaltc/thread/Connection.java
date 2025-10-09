package com.solvd.hospitaltc.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    private final String ID;
    private Boolean isActive = true;
    private static final Logger log = LogManager.getLogger(CustomRunnable.class);

    public Connection(String id) {
        this.ID = id;
        log.info(STR."Created connection: \{id}");
    }

    public String getID() {
        return ID;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void close() {
        this.isActive = false;
        log.info("Connection {} closed", ID);
    }
}
