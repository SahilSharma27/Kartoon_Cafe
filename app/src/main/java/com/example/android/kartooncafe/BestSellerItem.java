package com.example.android.kartooncafe;

import java.util.ArrayList;

public class BestSellerItem extends Item {
    private int backDropId;

    public BestSellerItem
            (String itemCode, String itemName, String itemDescription, int itemCategory, double itemPrice,
             int customizable, ArrayList<Customizables> customList, int backDropId) {
        super(itemCode, itemName, itemDescription, itemCategory, itemPrice, customizable, customList);
        this.backDropId = backDropId;
    }

    public int getBackDropId() {
        return backDropId;
    }

    public void setBackDropId(int backDropId) {
        this.backDropId = backDropId;
    }
}
