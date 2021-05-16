package com.symbiosis.nikhilmatta.expensetracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {

    Context context;
    List<addE> MainImageUploadInfoList;

    public recyclerViewAdapter(Context context, List<addE> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        addE addExpense = MainImageUploadInfoList.get(position);

        holder.displayNote.setText(addExpense.getNote());

        Double doubleAmount = addExpense.getAmount();

        String stringAmount = Double.toString(doubleAmount);

        holder.displayAmount.setText(stringAmount);

        /*      holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
                });        */
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView displayNote;
        public TextView displayAmount;

        public ViewHolder(View itemView) {

            super(itemView);

            displayNote = (TextView) itemView.findViewById(R.id.displayNote);

            displayAmount = (TextView) itemView.findViewById(R.id.displayAmount);


        }
    }
}