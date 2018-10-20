package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class fuelExpense extends AppCompatActivity {
ImageButton addFuelExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_expense);

        addFuelExpenseButton = (ImageButton) findViewById(R.id.addFuelExpenseButton);
        addFuelExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fuelExpense.this, addFuelExpenses.class);
                startActivity(intent);
            }
        });
    }
}
