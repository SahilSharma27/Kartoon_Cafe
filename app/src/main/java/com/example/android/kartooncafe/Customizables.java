package com.example.android.kartooncafe;

public class Customizables {
    private String customName;
    private double customPrice;
    private int custType;




    public Customizables(String customName, double customPrice, int custType) {
        this.customName = customName;
        this.customPrice = customPrice;
        this.custType = custType;
    }

    public int getCustType() {
        return custType;
    }

    public void setCustType(int custType) {
        this.custType = custType;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public double getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(double customPrice) {
        this.customPrice = customPrice;
    }
}

