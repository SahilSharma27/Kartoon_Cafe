package com.example.android.kartooncafe;

import java.util.ArrayList;

public class TableReservation {

    private String reservationId;
    private String reservationForDate;
    private String reservationForTime;
    private String numberOfPpl;
    private String userName;
    private String userEmail;
    private String userContact;
    private String specialOccassion;
    private String specialInstruction;
    private ArrayList<Cart> reservationOrderAheadList;
    private double orderTotal;
    private String reservationStatus;


    public TableReservation() {
    }


    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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

    public String getSpecialOccassion() {
        return specialOccassion;
    }

    public void setSpecialOccassion(String specialOccassion) {
        this.specialOccassion = specialOccassion;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
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

    public ArrayList<Cart> getReservationOrderAheadList() {
        return reservationOrderAheadList;
    }

    public void setReservationOrderAheadList(ArrayList<Cart> reservationOrderAheadList) {
        this.reservationOrderAheadList = reservationOrderAheadList;
    }

    public String getReservationForDate() {
        return reservationForDate;
    }

    public void setReservationForDate(String reservationForDate) {
        this.reservationForDate = reservationForDate;
    }

    public String getReservationForTime() {
        return reservationForTime;
    }

    public void setReservationForTime(String reservationForTime) {
        this.reservationForTime = reservationForTime;
    }


    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}

