package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class clothesExpense extends AppCompatActivity {
ImageButton addClothesExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_expense);
        addClothesExpenseButton = (ImageButton) findViewById(R.id.addClothesExpenseButton);
        addClothesExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(clothesExpense.this, addClothesExpense.class);
                startActivity(intent);
            }
        });


    }
}
