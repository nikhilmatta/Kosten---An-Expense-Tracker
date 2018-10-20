package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class miscellaneousExpense extends AppCompatActivity {
ImageButton addMiscellaneousExpenseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous_expense);

        addMiscellaneousExpenseButton = (ImageButton) findViewById(R.id.addMiscellaneousExpenseButton);
        addMiscellaneousExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(miscellaneousExpense.this, addMiscellaneousExpenses.class);
                startActivity(intent);
            }
        });
    }
}
