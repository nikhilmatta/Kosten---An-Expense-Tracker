package com.symbiosis.nikhilmatta.expensetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addClothesExpense extends AppCompatActivity {

    private FirebaseAuth currentUser;
    private DatabaseReference mDatabase;
    public EditText addNote;
    public EditText enterAmountTextField;
    public Button saveClothesExpenseButton;
    public Double amount;
    public String amountString;
    public String note;
    public addE addClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes_expense);
        addClothes = new addE();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        enterAmountTextField = (EditText) findViewById(R.id.enterClothesAmountTextField);
        addNote = (EditText) findViewById(R.id.addClothesNoteTextField);


        saveClothesExpenseButton = (Button) findViewById(R.id.saveClothesExpenseButton);
        saveClothesExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                note = addNote.getText().toString();
                amountString = enterAmountTextField.getText().toString();
                amount = Double.parseDouble(amountString);
                addClothes.setAmount(amount);
                addClothes.setNote(note);
                currentUser = FirebaseAuth.getInstance();

                String uID = currentUser.getCurrentUser().getUid();


                mDatabase.child(uID).child("personalExpenses").child("Clothes").push().setValue(addClothes);
                Toast.makeText(addClothesExpense.this,"Expense Added",Toast.LENGTH_SHORT).show();
                finish();

            }
        });









    }
}
