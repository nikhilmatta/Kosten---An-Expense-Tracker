package com.symbiosis.nikhilmatta.expensetracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class layoutGroupExpense  extends AppCompatActivity{

    ImageButton createGroupExpenseButton;
    RecyclerView recyclerView;
    groupExpenseRecyclerViewAdapter groupExpenseRecyclerViewAdapter;
    List<addGroup> addGroupArrayList = new ArrayList<>();
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth currentUser;
    ProgressDialog progressDialog;
    String gID;
TextView groupNameTextViev;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_expense_layout);
        getIncomingIntent();
        groupNameTextViev = (TextView) findViewById(R.id.groupNameText);
        gID = groupNameTextViev.getText().toString();
        createGroupExpenseButton = (ImageButton) findViewById(R.id.saveGroupExpenseButton);
        createGroupExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(layoutGroupExpense.this, addExpense.class);
                intent.putExtra("groupID", gID);
                startActivity(intent);
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.groupExpenseListRecyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        groupExpenseRecyclerViewAdapter = new groupExpenseRecyclerViewAdapter(this, addGroupArrayList);

        progressDialog = new ProgressDialog(layoutGroupExpense.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();



        //Method call for populating the view
        populateRecyclerViewValues();




    }

    private void populateRecyclerViewValues() {

        currentUser = FirebaseAuth.getInstance();

        String uID = currentUser.getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uID).child("groupExpenses").child(gID);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    addGroup addGroup = dataSnapshot.getValue(addGroup.class);

                    addGroupArrayList.add(addGroup);
                }

                groupExpenseRecyclerViewAdapter = new groupExpenseRecyclerViewAdapter(layoutGroupExpense.this, addGroupArrayList);

                recyclerView.setAdapter(groupExpenseRecyclerViewAdapter);

                progressDialog.dismiss();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();


            }
        });



    }




    private void getIncomingIntent() {

        if(getIntent().hasExtra("group_name")){

            String group_name = getIntent().getStringExtra("group_name");
            setGroupName(group_name);
        }

    }

    private void setGroupName(String groupName){

        TextView name = (TextView) findViewById(R.id.groupNameText);
        name.setText(groupName);

    }

}
