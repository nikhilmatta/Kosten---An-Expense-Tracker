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

public class entertainmentExpense extends AppCompatActivity {
ImageButton addEntertainmentExpenseButton;
    FirebaseAuth currentUser;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<addE> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_expense);

        recyclerView = (RecyclerView) findViewById(R.id.entertainmentExpensesRecyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(entertainmentExpense.this));

        progressDialog = new ProgressDialog(entertainmentExpense.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        currentUser = FirebaseAuth.getInstance();

        String uID = currentUser.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uID).child("personalExpenses").child("Entertainment");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    addE addExpense = dataSnapshot.getValue(addE.class);

                    list.add(addExpense);
                }

                adapter = new recyclerViewAdapter(entertainmentExpense.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

        addEntertainmentExpenseButton = (ImageButton) findViewById(R.id.addEntertainmentExpenseButton);
        addEntertainmentExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entertainmentExpense.this, addEntertainmentExpenses.class);
                startActivity(intent);
            }
        });
    }
}
