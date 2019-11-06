package com.example.android.kartooncafe;

import java.util.ArrayList;

public class Item {
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private int itemCategory;// Veg=0,non-veg=1,option=2
    private double itemPrice;
    private int customizable;//o-no,1-yes
    private ArrayList<Customizables> customList;


//    public Item(String itemCode, String itemName, double itemPrice) {
//        this.itemCode = itemCode;
//        this.itemName = itemName;
//        this.itemPrice = itemPrice;
//

    public Item(String itemCode, String itemName, String itemDescription, int itemCategory, double itemPrice, int customizable, ArrayList<Customizables> customList) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.customizable = customizable;
        this.customList = customList;
    }

//    public Item(String itemCode, String itemName, String itemDescription, int itemCategory, double itemPrice, int customizable) {
//        this.itemCode = itemCode;
//        this.itemName = itemName;
//        this.itemDescription = itemDescription;
//        this.itemCategory = itemCategory;
//        this.itemPrice = itemPrice;
//        this.customizable = customizable;
//    }


//    public Item(String itemCode, String itemName, String itemDescription, int itemCategory, double itemPrice) {
//        this.itemCode = itemCode;
//        this.itemName = itemName;
//        this.itemDescription = itemDescription;
//        this.itemCategory = itemCategory;
//        this.itemPrice = itemPrice;
//    }

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
}
