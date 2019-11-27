package com.example.android.kartooncafe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Item implements Parcelable {
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int customizable;//o-no,1-yes
    private ArrayList<Customizables> customList;
    private int itemCategory;// Veg=0,non-veg=1,option=2,egg=3
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };


    public Item(String itemCode, String itemName, String itemDescription, int itemCategory, double itemPrice, int customizable, ArrayList<Customizables> customList) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.customizable = customizable;
        this.customList = customList;
    }


    protected Item(Parcel in) {
        itemCode = in.readString();
        itemName = in.readString();
        itemDescription = in.readString();
        itemCategory = in.readInt();
        itemPrice = in.readDouble();
        customizable = in.readInt();
        customList = in.createTypedArrayList(Customizables.CREATOR);
    }

    public int getCustomizable() {
        return customizable;
    }

    public void setCustomizable(int customizable) {
        this.customizable = customizable;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(int itemCategory) {
        this.itemCategory = itemCategory;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ArrayList<Customizables> getCustomList() {
        return customList;
    }

    public void setCustomList(ArrayList<Customizables> customList) {
        this.customList = customList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(itemCode);
        parcel.writeString(itemName);
        parcel.writeString(itemDescription);
        parcel.writeInt(itemCategory);
        parcel.writeDouble(itemPrice);
        parcel.writeInt(customizable);
        parcel.writeTypedList(customList);
    }


}
