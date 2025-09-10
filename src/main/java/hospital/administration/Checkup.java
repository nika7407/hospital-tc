package hospital.administration;

import hospital.worker.Patient;

public interface Checkup<T> {
     void checkup(T objectToCheck);

}
