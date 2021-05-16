package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button profileButton;
    Button personalExpensesButton;
    Button groupExpensesButton;
    TextView appNameText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appNameText = (TextView) findViewById(R.id.appNameText);
        profileButton = (Button) findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });

        personalExpensesButton = (Button) findViewById(R.id.personalExpensesButton);
        personalExpensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, personalExpenses.class);
                startActivity(intent);
            }
        });

        groupExpensesButton = (Button) findViewById(R.id.groupExpensesButton);
        groupExpensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, groupExpenses.class);
                startActivity(intent);
            }
        });

    }
}
