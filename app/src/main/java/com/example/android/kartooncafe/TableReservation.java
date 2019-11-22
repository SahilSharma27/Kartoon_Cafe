package com.example.android.kartooncafe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TableReservation implements Parcelable {

    public static final Creator<TableReservation> CREATOR = new Creator<TableReservation>() {
        @Override
        public TableReservation createFromParcel(Parcel in) {
            return new TableReservation(in);
        }

        @Override
        public TableReservation[] newArray(int size) {
            return new TableReservation[size];
        }
    };
    private int reservationId;
    private String reservationDate;
    private String reservationTime;
    private String numberOfPpl;
    private String userName;
    private String userEmail;
    private String userContact;
    private String specialOcassion;
    private String specialInstruction;
    private ArrayList<Cart> reservtaionOrderAheadList;
    private double orderTotal;


    public TableReservation() {
    }

    protected TableReservation(Parcel in) {
        reservationId = in.readInt();
        reservationDate = in.readString();
        reservationTime = in.readString();
        numberOfPpl = in.readString();
        userName = in.readString();
        userEmail = in.readString();
        userContact = in.readString();
        specialOcassion = in.readString();
        specialInstruction = in.readString();
        reservtaionOrderAheadList = in.createTypedArrayList(Cart.CREATOR);
        orderTotal = in.readDouble();
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
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

    public String getSpecialOcassion() {
        return specialOcassion;
    }

    public void setSpecialOcassion(String specialOcassion) {
        this.specialOcassion = specialOcassion;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public ArrayList<Cart> getReservtaionOrderAheadList() {
        return reservtaionOrderAheadList;
    }

    public void setReservtaionOrderAheadList(ArrayList<Cart> reservtaionOrderAheadList) {
        this.reservtaionOrderAheadList = reservtaionOrderAheadList;
    }

    public String getNumberOfPpl() {
        return numberOfPpl;
    }

    public void setNumberOfPpl(String numberOfPpl) {
        this.numberOfPpl = numberOfPpl;
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
        parcel.writeInt(reservationId);
        parcel.writeString(reservationDate);
        parcel.writeString(reservationTime);
        parcel.writeString(numberOfPpl);
        parcel.writeString(userName);
        parcel.writeString(userEmail);
        parcel.writeString(userContact);
        parcel.writeString(specialOcassion);
        parcel.writeString(specialInstruction);
        parcel.writeTypedList(reservtaionOrderAheadList);
        parcel.writeDouble(orderTotal);
    }
}
