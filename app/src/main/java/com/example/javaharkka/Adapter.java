/*
CiviVPlanner; Android Studio; Tommi Kunnari; Adapter.class;

This adapter manages adding new entry.xml cardviews containing
an EntryItem's info to a recyclerview.
*/

package com.example.javaharkka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private OnItemClickListener mListener;
    private ArrayList<EntryItem> mEntryList;

    public interface OnItemClickListener {
        void itemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView techView;
        TextView numView;
        ImageView deleteImage;

        ViewHolder(@NonNull View itemView, final OnItemClickListener listener)
        {
            super(itemView);
            techView = itemView.findViewById(R.id.planName);
            numView = itemView.findViewById(R.id.number);
            deleteImage = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { // Adds a clicklistener to the newly created cardview
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });
            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {   // Adds a clicklistener to delete the new entry
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public Adapter(ArrayList<EntryItem> entryList) {
        mEntryList = entryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Attaches an EntryItem's info to a entry.xml layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry,parent,false);
        ViewHolder viewHolder = new ViewHolder(v, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // Inserts the newly made entry to the desired recyclerview
        EntryItem currentItem = mEntryList.get(position);
        holder.techView.setText(currentItem.getTechName());
        holder.numView.setText(String.valueOf(currentItem.getNumber()));
    }

    @Override
    public int getItemCount() {
        return mEntryList.size();
    }
}
