package com.example.skyhighfinal;

import androidx.appcompat.app.AppCompatActivity;


public class Ticket extends AppCompatActivity{

    String passengerName, passengerAge, passengerType, gender, classFlight;

    // Constructor method
    public Ticket(String passengerName, String passengerAge, String passengerType, String gender, String classFlight) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerType = passengerType;
        this.gender = gender;
        this.classFlight = classFlight;
    }
    // Getters
    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerAge() {
        return passengerAge;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public String getGender() {
        return gender;
    }

    public String getClassFlight() {
        return classFlight;
    }
}
