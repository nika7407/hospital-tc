package hospital.drug;

import java.util.function.Supplier;

public class DrugGenerator {

    public static Drug generate(Supplier<Drug> drugSupplier) {
        return drugSupplier.get();
    }
}
