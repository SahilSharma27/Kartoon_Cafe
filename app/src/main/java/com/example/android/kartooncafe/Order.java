package com.example.android.kartooncafe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Order implements Parcelable {
    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
    private int orderId;
    private String orderDate;
    private String orderTime;
    private String userName;
    private String userEmail;
    private String userContact;
    private String userAddress;
    private String specialInstruction;
    private ArrayList<Cart> orderList;
    private double orderTotal;


    public Order() {
    }

    protected Order(Parcel in) {
        orderId = in.readInt();
        orderDate = in.readString();
        orderTime = in.readString();
        userName = in.readString();
        userEmail = in.readString();
        userContact = in.readString();
        userAddress = in.readString();
        specialInstruction = in.readString();
        orderList = in.createTypedArrayList(Cart.CREATOR);
        orderTotal = in.readDouble();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public ArrayList<Cart> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Cart> orderList) {
        this.orderList = orderList;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(orderId);
        parcel.writeString(orderDate);
        parcel.writeString(orderTime);
        parcel.writeString(userName);
        parcel.writeString(userEmail);
        parcel.writeString(userContact);
        parcel.writeString(userAddress);
        parcel.writeString(specialInstruction);
        parcel.writeTypedList(orderList);
        parcel.writeDouble(orderTotal);
    }
}
