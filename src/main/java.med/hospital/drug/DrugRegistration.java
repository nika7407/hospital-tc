package hospital.drug;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class DrugRegistration {

    private Set<Drug> registeredDrugs = new HashSet<>();

    public void registerDrug(Drug drug, Consumer<Drug> registrationLogic) {
        registrationLogic.accept(drug);
        registeredDrugs.add(drug);
    }

    public boolean isRegistered(Drug drug) {
        return registeredDrugs.contains(drug);
    }

    public Set<Drug> getRegisteredDrugs() {
        return registeredDrugs;
    }
}
