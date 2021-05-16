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

public class addExpense extends AppCompatActivity {

    private FirebaseAuth currentUser;
    private DatabaseReference mDatabase;
    public EditText addNote;
    public EditText enterAmountTextField;
    public Button saveGroupExpenseButton;
    public Double amount;
    public String amountString;
    public String note;
    public addGroup addGroup;
    public EditText addName;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);



        addGroup = new addGroup();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        enterAmountTextField = (EditText) findViewById(R.id.enterGroupAmountTextField);
        addNote = (EditText) findViewById(R.id.addGroupNoteTextField);
        addName = (EditText) findViewById(R.id.enterNameTextFieldGroup);

        saveGroupExpenseButton = (Button) findViewById(R.id.saveGroupExpenseButton);
        saveGroupExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gID = getIntent().getExtras().get("groupID").toString();
                //Intent intent = getIntent();
                //String gID = intent.getStringExtra(layoutGroupExpense.class,"groupID");
                note = addNote.getText().toString();
                amountString = enterAmountTextField.getText().toString();
                amount = Double.parseDouble(amountString);
                addGroup.setAmount(amount);
                addGroup.setNote(note);
                name = addName.getText().toString();
                addGroup.setName(name);
                currentUser = FirebaseAuth.getInstance();

                String uID = currentUser.getCurrentUser().getUid();


                mDatabase.child("users").child(uID).child("groupExpenses").child(gID).push().setValue(addGroup);
                Toast.makeText(addExpense.this,"Expense Added",Toast.LENGTH_SHORT).show();
                finish();
                //Intent intent = new Intent(addExpense.this, MainActivity.class);
                //startActivity(intent);

            }
        });

    }
}
