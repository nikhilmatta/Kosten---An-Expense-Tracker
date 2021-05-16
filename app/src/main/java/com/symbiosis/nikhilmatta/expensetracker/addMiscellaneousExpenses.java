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

public class addMiscellaneousExpenses extends AppCompatActivity {

    private FirebaseAuth currentUser;
    private DatabaseReference mDatabase;
    public EditText addNote;
    public EditText enterAmountTextField;
    public Button saveMiscellaneousExpenseButton;
    public Double amount;
    public String amountString;
    public String note;
    public addE addMiscellaneous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_miscellaneous_expenses);
        addMiscellaneous = new addE();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        enterAmountTextField = (EditText) findViewById(R.id.enterMiscellaneousAmountTextField);
        addNote = (EditText) findViewById(R.id.addMiscellaneousNoteTextField);


        saveMiscellaneousExpenseButton = (Button) findViewById(R.id.saveMiscellaneousExpenseButton);
        saveMiscellaneousExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                note = addNote.getText().toString();
                amountString = enterAmountTextField.getText().toString();
                amount = Double.parseDouble(amountString);
                addMiscellaneous.setAmount(amount);
                addMiscellaneous.setNote(note);
                currentUser = FirebaseAuth.getInstance();

                String uID = currentUser.getCurrentUser().getUid();


                mDatabase.child("users").child(uID).child("personalExpenses").child("Miscellaneous").push().setValue(addMiscellaneous);
                Toast.makeText(addMiscellaneousExpenses.this,"Expense Added",Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(addMiscellaneousExpenses.this, personalExpenses.class);
                startActivity(intent);

            }
        });









    }
}
