package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class groupExpenseRecyclerViewAdapter extends RecyclerView.Adapter<groupExpenseRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<addGroup> addGroupList;

    public groupExpenseRecyclerViewAdapter(Context context, List<addGroup> TempList) {

        this.addGroupList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_groupexpenselist, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(groupExpenseRecyclerViewAdapter.ViewHolder holder, int position) {
        addGroup addGroup = addGroupList.get(position);

        holder.displayNote.setText(addGroup.getNote());

        Double doubleAmount = addGroup.getAmount();

        String stringAmount = Double.toString(doubleAmount);

        holder.displayAmount.setText(stringAmount);

        holder.displayName.setText(addGroup.getName());
    }



    @Override
    public int getItemCount() {

        return addGroupList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView displayNote;
        public TextView displayAmount;
        public TextView displayName;

        public ViewHolder(View itemView) {

            super(itemView);

            displayNote = (TextView) itemView.findViewById(R.id.displayNote);

            displayAmount = (TextView) itemView.findViewById(R.id.displayAmount);

            displayName = (TextView) itemView.findViewById(R.id.displayName);


        }
    }
}