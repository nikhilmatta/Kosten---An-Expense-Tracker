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

public class createGroup extends AppCompatActivity {
    Button saveGroupButton;
    addGroup addGroup;
    EditText groupNameTextField;
    String name;
    FirebaseAuth currentUser;
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    groupName groupName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        saveGroupButton = (Button) findViewById(R.id.saveGroupButton);
        groupNameTextField = (EditText) findViewById(R.id.groupNameText);
        saveGroupButton = (Button) findViewById(R.id.saveGroupButton);

        saveGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                groupName = new groupName();
                name = groupNameTextField.getText().toString();

                groupName.setName(name);

                mDatabase = firebaseDatabase.getInstance().getReference();

                currentUser = FirebaseAuth.getInstance();

                String uID = currentUser.getCurrentUser().getUid();


                mDatabase.child("users").child(uID).child("groupExpenses").child(name).setValue(name);
                mDatabase.child("users").child(uID).child("groupNames").child(name).setValue(name);

                Toast.makeText(createGroup.this, "Group Created", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(createGroup.this, groupExpenses.class);
                startActivity(intent);

            }
        });


    }




}