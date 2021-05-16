package com.symbiosis.nikhilmatta.expensetracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class foodExpense extends AppCompatActivity {

    ImageButton addFoodExpenseButton;

    FirebaseDatabase databaseRef;

    FirebaseAuth currentUser;

    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<addE> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_expense);

        recyclerView = (RecyclerView) findViewById(R.id.foodExpenseRecyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(foodExpense.this));

        progressDialog = new ProgressDialog(foodExpense.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        currentUser = FirebaseAuth.getInstance();

        String uID = currentUser.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uID).child("personalExpenses").child("Food");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    addE addExpense = dataSnapshot.getValue(addE.class);

                    list.add(addExpense);
                }

                adapter = new recyclerViewAdapter(foodExpense.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });




        addFoodExpenseButton = (ImageButton) findViewById(R.id.addFoodExpenseButton);
        addFoodExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(foodExpense.this, addFoodExpense.class);
                startActivity(intent);
            }
        });


    }
}
