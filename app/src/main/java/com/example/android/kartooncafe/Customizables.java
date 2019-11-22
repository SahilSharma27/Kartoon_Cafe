package com.example.android.kartooncafe;

import android.os.Parcel;
import android.os.Parcelable;

public class Customizables implements Parcelable {
    private String customName;
    private double customPrice;
    private int custType;




    public Customizables(String customName, double customPrice, int custType) {
        this.customName = customName;
        this.customPrice = customPrice;
        this.custType = custType;
    }

    public static final Creator<Customizables> CREATOR = new Creator<Customizables>() {
        @Override
        public Customizables createFromParcel(Parcel in) {
            return new Customizables(in);
        }

        @Override
        public Customizables[] newArray(int size) {
            return new Customizables[size];
        }
    };

    protected Customizables(Parcel in) {
        customName = in.readString();
        customPrice = in.readDouble();
        custType = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(customName);
        parcel.writeDouble(customPrice);
        parcel.writeInt(custType);
    }
}

