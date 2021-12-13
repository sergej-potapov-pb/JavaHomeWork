package com.pb.potapov.hw12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PhoneBookItem {
    public String name;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    public LocalDate bDay;
    public LinkedList<String> phoneNumbers;
    public String address;
    public Date timeStamp;

    // for deserialisation !!!
    public PhoneBookItem() {};

    public PhoneBookItem(String name, LocalDate bDay, String address) {
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

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
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
        return name + "(" + bDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ')' +
                ", "+ address + ", timeStamp=" + timeStamp +
                "\n   " + phoneNumbers;
    }
}
