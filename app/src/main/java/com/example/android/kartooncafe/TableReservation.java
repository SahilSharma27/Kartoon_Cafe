package com.example.android.kartooncafe;

import java.util.ArrayList;

public class TableReservation {

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


}
