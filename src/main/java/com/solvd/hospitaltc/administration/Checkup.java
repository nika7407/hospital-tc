package com.solvd.hospitaltc.administration;

import com.solvd.hospitaltc.exception.CheckupException;

public interface Checkup<T> {

    void checkup(T objectToCheck) throws CheckupException;

}
