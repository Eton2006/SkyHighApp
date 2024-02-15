package com.example.skyhighfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class Payment extends AppCompatActivity {
    EditText editTextMonthExp, editTextYearExp, editTextCardNumber, editTextCvv;
    TextView textViewTotalFare;
    Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //Creating button
        payBtn = findViewById(R.id.pay);
        textViewTotalFare = findViewById(R.id.totalFare);

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    public void openHome(){
        Intent intent = new Intent(getApplicationContext(), Mainmenu.class);
        startActivity(intent);
        Toast.makeText(this, "Your payment was successful", Toast.LENGTH_SHORT).show();
        finish();
    }

}
