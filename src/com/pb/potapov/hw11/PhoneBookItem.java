package com.pb.potapov.hw11;

import java.util.Date;
import java.util.LinkedList;

public class PhoneBookItem {
    public String name;
    public String bDay;
    public LinkedList<String> phoneNumbers;
    public String address;
    public Date timeStamp;

    public PhoneBookItem(String name, String bDay, String address) {
        this.name = name;
        this.bDay = bDay;
        this.phoneNumbers = new LinkedList<>();
        this.address = address;
        this.timeStamp = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setTimeStamp();
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
        setTimeStamp();
    }

    public LinkedList getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(LinkedList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        setTimeStamp();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setTimeStamp();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = new Date();
    }

    @Override
    public String toString() {
        return name + "(" + bDay + ')' +
                ", "+ address + ", timeStamp=" + timeStamp +
                "\n   " + phoneNumbers;
    }
}
