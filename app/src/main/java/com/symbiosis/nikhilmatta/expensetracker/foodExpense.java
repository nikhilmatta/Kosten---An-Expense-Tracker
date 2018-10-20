package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.FirebaseDatabase;

public class foodExpense extends AppCompatActivity {

    ImageButton addFoodExpenseButton;
    FirebaseDatabase databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_expense);



        addFoodExpenseButton = (ImageButton) findViewById(R.id.addFoodExpenseButton);
        addFoodExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodExpense.this, addFoodExpense.class);
                startActivity(intent);
            }
        });


    }
}
