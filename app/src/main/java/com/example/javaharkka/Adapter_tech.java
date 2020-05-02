package com.example.javaharkka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_tech extends RecyclerView.Adapter<Adapter_tech.ViewHolder> {

    private ArrayList<EntryItem> mEntryList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView entryView, numView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            entryView = itemView.findViewById(R.id.entryName);
            numView = itemView.findViewById(R.id.number);
        }
    }

    public Adapter_tech(ArrayList<EntryItem> entryList) {
        mEntryList = entryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_review,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EntryItem currentItem = mEntryList.get(position);
        holder.entryView.setText(currentItem.getTechName());
        holder.numView.setText(String.valueOf(currentItem.getNumber()));
    }

    @Override
    public int getItemCount() {
        return mEntryList.size();
    }
}

