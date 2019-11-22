package com.example.android.kartooncafe;

import android.os.Parcel;
import android.os.Parcelable;

public class Cart implements Parcelable {
    private Item cartItem;
    private int quantity;
    private double total;
    private Customizables custom;


    public Cart(Item cartItem, int quantity, double total) {
        this.cartItem = cartItem;
        this.quantity = quantity;
        this.total = total;
    }


    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    protected Cart(Parcel in) {
        cartItem = in.readParcelable(Item.class.getClassLoader());
        quantity = in.readInt();
        total = in.readDouble();
        custom = in.readParcelable(Customizables.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(cartItem, i);
        parcel.writeInt(quantity);
        parcel.writeDouble(total);
        parcel.writeParcelable(custom, i);
    }
}
