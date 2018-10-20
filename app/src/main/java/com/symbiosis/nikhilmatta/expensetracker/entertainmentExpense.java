package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class entertainmentExpense extends AppCompatActivity {
ImageButton addEntertainmentExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_expense);

        addEntertainmentExpenseButton = (ImageButton) findViewById(R.id.addEntertainmentExpenseButton);
        addEntertainmentExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entertainmentExpense.this, addEntertainmentExpenses.class);
                startActivity(intent);
            }
        });
    }
}
