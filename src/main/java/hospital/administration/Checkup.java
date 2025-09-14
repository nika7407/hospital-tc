package hospital.administration;

import hospital.exception.CheckupException;

public interface Checkup<T> {

    void checkup(T objectToCheck) throws CheckupException;

}
