package com.example.android.kartooncafe;

public class Cart {
    private Item cartItem;
    private int quantity;
    private double total;
    private Customizables custom;


    public Cart(Item cartItem, int quantity, double total) {
        this.cartItem = cartItem;
        this.quantity = quantity;
        this.total = total;
    }

    public Item getCartItem() {
        return cartItem;
    }

    public void setCartItem(Item cartItem) {
        this.cartItem = cartItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



    public Customizables getCustom() {
        return custom;
    }

    public void setCustom(Customizables custom) {
        this.custom = custom;
    }
}
