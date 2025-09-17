package hospital.drug;

public class DrugDelivery<D extends Drug> {

    private String deliveryCompany;
    private D drugToDeliver;

    public DrugDelivery(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public D getDrugToDeliver() {
        return drugToDeliver;
    }

    public void setDrugToDeliver(D drugToDeliver) {
        this.drugToDeliver = drugToDeliver;
    }

    public void deliverDrug() {

        if (drugToDeliver == null) {
            System.out.println("there's no drugs to deliver");
        }
        System.out.println("\nDrug: " + drugToDeliver.getName() + " is delivered");
        drugToDeliver = null;
    }
}
