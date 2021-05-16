package com.symbiosis.nikhilmatta.expensetracker;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class groupExpenses extends AppCompatActivity {

    ImageButton createGroup;
    RecyclerView recyclerView;
    groupRecyclerViewAdapter groupRecyclerViewAdapter;
    ArrayList<String> groupNameArrayList = new ArrayList<>();
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth currentUser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_expenses);

        recyclerView = (RecyclerView) findViewById(R.id.groupExpenseRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        groupRecyclerViewAdapter = new groupRecyclerViewAdapter(this, groupNameArrayList);

        progressDialog = new ProgressDialog(groupExpenses.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        //Method call for populating the view
        populateRecyclerViewValues();


        createGroup = (ImageButton) findViewById(R.id.createGroup);
        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(groupExpenses.this, createGroup.class);
                startActivity(intent);
            }
        });
    }

    private void populateRecyclerViewValues() {

        currentUser = FirebaseAuth.getInstance();

        String uID = currentUser.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uID).child("groupNames");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    String Name = dataSnapshot.getValue(String.class);

                    groupNameArrayList.add(Name);
                }

                groupRecyclerViewAdapter = new groupRecyclerViewAdapter(groupExpenses.this, groupNameArrayList);

                recyclerView.setAdapter(groupRecyclerViewAdapter);

                progressDialog.dismiss();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();


            }
        });





    }
}





