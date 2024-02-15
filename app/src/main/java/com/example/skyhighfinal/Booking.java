package com.example.skyhighfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextPassengerName, editTextPassengerAge;
    Button buttonAddPassenger, buttonProceed;

    Spinner spinnerPassengerType, spinnerGender, spinnerClassFlight;
    DatabaseReference ticketDbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        spinnerPassengerType = findViewById(R.id.passengerType);
        editTextPassengerName = findViewById(R.id.passengerName);
        editTextPassengerAge = findViewById(R.id.passengerAge);
        spinnerGender = findViewById(R.id.gender);
        spinnerClassFlight = findViewById(R.id.classFlight);
        buttonAddPassenger = findViewById(R.id.addPassenger);
        buttonProceed = findViewById(R.id.proceed);

        ticketDbRef = FirebaseDatabase.getInstance().getReference().child("Ticket");

        buttonProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayment();
            }
        });

        buttonAddPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertTicketData();
            }
        });
        // Creating drop down menu for passenger type
        Spinner spinner = findViewById(R.id.passengerType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.passengerType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.classFlight);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.classFlight, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void insertTicketData(){
        String passengerName = editTextPassengerName.getText().toString();
        String passengerAge = editTextPassengerAge.getText().toString();
        String passengerType = spinnerPassengerType.getSelectedItem().toString();
        String gender = spinnerGender.getSelectedItem().toString();
        String classFlight = spinnerClassFlight.getSelectedItem().toString();

        Ticket ticket = new Ticket(passengerName, passengerAge, passengerType, gender, classFlight);
        //  Push method
        ticketDbRef.push().setValue(ticket);
        Toast.makeText(Booking.this,"Passenger added",Toast.LENGTH_SHORT).show();
    }

    private void openPayment(){
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);
    }

}