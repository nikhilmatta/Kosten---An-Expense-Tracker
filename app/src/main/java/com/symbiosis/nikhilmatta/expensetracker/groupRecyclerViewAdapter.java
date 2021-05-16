package com.symbiosis.nikhilmatta.expensetracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class groupRecyclerViewAdapter extends RecyclerView.Adapter<groupRecyclerViewAdapter.ViewHolder>  {

    Context context;
    List<String> groupNameList = new ArrayList<>();
    DatabaseReference reference;

    public groupRecyclerViewAdapter(Context context, List<String> TempList) {

        this.groupNameList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_group, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String groupName = groupNameList.get(position);

        holder.displayGroupName.setText(groupName);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Pressed",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, layoutGroupExpense.class);
                intent.putExtra("group_name", groupNameList.get(position));
                context.startActivity(intent);
            }
        });





    }
    public void setListContent(ArrayList<String> addGroupArrayList){
        this.groupNameList = addGroupArrayList;
        notifyItemRangeChanged(0,addGroupArrayList.size());

    }

    @Override
    public int getItemCount() {

        return groupNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {

        public TextView displayGroupName;

        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            displayGroupName = (TextView) itemView.findViewById(R.id.displayGroupName);

            parentLayout = itemView.findViewById(R.id.parentLayout);

            context = itemView.getContext();


        }

        @Override
        public void onClick(View view) {



        }

    }
}