package com.symbiosis.nikhilmatta.expensetracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class fuelExpense extends AppCompatActivity {
ImageButton addFuelExpenseButton;

    FirebaseAuth currentUser;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<addE> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_expense);

        recyclerView = (RecyclerView) findViewById(R.id.fuelExpenseRecyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(fuelExpense.this));

        progressDialog = new ProgressDialog(fuelExpense.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        currentUser = FirebaseAuth.getInstance();

        String uID = currentUser.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uID).child("personalExpenses").child("Fuel");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    addE addExpense = dataSnapshot.getValue(addE.class);

                    list.add(addExpense);
                }

                adapter = new recyclerViewAdapter(fuelExpense.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

        addFuelExpenseButton = (ImageButton) findViewById(R.id.addFuelExpenseButton);
        addFuelExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fuelExpense.this, addFuelExpenses.class);
                startActivity(intent);
            }
        });
    }
}
