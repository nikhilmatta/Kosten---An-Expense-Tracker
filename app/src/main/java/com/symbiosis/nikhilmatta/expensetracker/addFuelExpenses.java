package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addFuelExpenses extends AppCompatActivity {

    private FirebaseAuth currentUser;
    private DatabaseReference mDatabase;
    public EditText addNote;
    public EditText enterAmountTextField;
    public Button saveFuelExpenseButton;
    public Double amount;
    public String amountString;
    public String note;
    public addE addFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel_expenses);
        addFuel = new addE();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        enterAmountTextField = (EditText) findViewById(R.id.enterFuelAmountTextField);
        addNote = (EditText) findViewById(R.id.addFuelNoteTextField);


        saveFuelExpenseButton = (Button) findViewById(R.id.saveFuelExpenseButton);
        saveFuelExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                note = addNote.getText().toString();
                amountString = enterAmountTextField.getText().toString();
                amount = Double.parseDouble(amountString);
                addFuel.setAmount(amount);
                addFuel.setNote(note);
                currentUser = FirebaseAuth.getInstance();

                String uID = currentUser.getCurrentUser().getUid();


                mDatabase.child("users").child(uID).child("personalExpenses").child("Fuel").push().setValue(addFuel);
                Toast.makeText(addFuelExpenses.this, "Expense Added", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(addFuelExpenses.this, personalExpenses.class);
                startActivity(intent);

            }
        });

    }
}