package com.example.android.kartooncafe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CartTable")
public class Cart {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_item_id")
    private int cartItemId;
    @ColumnInfo(name = "cart_item_name")
    private String cartItemName;
    @ColumnInfo(name = "cart_item_qty")
    private int quantity;
    @ColumnInfo(name = "cart_item_price")
    private double price;
    @ColumnInfo(name = "cart_item_custom")
    private String custom;
    @ColumnInfo(name = "cart_item_custom_price")
    private double customPrice;
    @ColumnInfo(name = "cart_item_catg")
    private int cartItemCategory;//veg , non veg , egg


    public Cart(String cartItemName, int quantity, double price) {
        this.cartItemName = cartItemName;
        this.quantity = quantity;
        this.price = price;
    }


    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public void setCartItemName(String cartItemName) {
        this.cartItemName = cartItemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public double getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(double customPrice) {
        this.customPrice = customPrice;
    }

    public int getCartItemCategory() {
        return cartItemCategory;
    }

    public void setCartItemCategory(int cartItemCategory) {
        this.cartItemCategory = cartItemCategory;
    }


}
