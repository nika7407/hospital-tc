package com.solvd.hospitaltc.drug;

import java.util.function.Consumer;

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

    public void deliverDrug(Consumer<Drug> drugUnload) {
        drugUnload.accept(drugToDeliver);
    }
}
