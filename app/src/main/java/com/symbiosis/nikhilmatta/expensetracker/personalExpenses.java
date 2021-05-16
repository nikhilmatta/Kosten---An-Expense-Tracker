package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class personalExpenses extends AppCompatActivity {

    ImageButton addExpense;
    Button foodButton;
    Button fuelButton;
    Button entertainmentButton;
    Button clothesButton;
    Button miscellaneousButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_expenses);



        foodButton = (Button) findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personalExpenses.this, foodExpense.class);
                startActivity(intent);
            }
        });

        fuelButton = (Button) findViewById(R.id.fuelButton);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personalExpenses.this, fuelExpense.class);
                startActivity(intent);
            }
        });

        entertainmentButton = (Button) findViewById(R.id.entertainmentButton);
        entertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personalExpenses.this, entertainmentExpense.class);
                startActivity(intent);
            }
        });

        clothesButton = (Button) findViewById(R.id.clothesButton);
        clothesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personalExpenses.this, clothesExpense.class);
                startActivity(intent);
            }
        });

        miscellaneousButton = (Button) findViewById(R.id.miscellaneousButton);
        miscellaneousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personalExpenses.this, miscellaneousExpense.class);
                startActivity(intent);
            }
        });


    }
}
