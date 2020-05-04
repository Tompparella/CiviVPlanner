/*
CiviVPlanner; Android Studio; Tommi Kunnari; Adapter_tech.class;

This adapter manages adding new entry_policy.xml cardviews containing
a EntryItem's info to a recyclerview. A modified version of Adapter. I know
this could have been done a bit more cleanly, but this works so I'm going
with it for now. I might fix this in the future. This one doesn't introduce
any clicklisteners.
*/

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
        TextView entryView;
        TextView numView;

        ViewHolder(@NonNull View itemView)
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {         // Attaches a EntryItem's info to a entry_browse.xml layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_review,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {                // Adds the newly created entry to the desired recyclerview
        EntryItem currentItem = mEntryList.get(position);
        holder.entryView.setText(currentItem.getTechName());
        holder.numView.setText(String.valueOf(currentItem.getNumber()));
    }

    @Override
    public int getItemCount() {
        return mEntryList.size();
    }
}

