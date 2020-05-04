/*
CiviVPlanner; Android Studio; Tommi Kunnari; Adapter_browse.class;

This adapter manages adding new entry_browse.xml cardviews containing
a Plan's info to a recyclerview. A modified version of Adapter. I know
this could have been done a bit more cleanly, but this works so I'm going
with it for now. I might fix this in the future.
*/

package com.example.javaharkka;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Math;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_browse extends RecyclerView.Adapter<Adapter_browse.ViewHolder_browse> {

    private OnItemClickListener mListener;
    private ArrayList<Plan> mEntryList;

    public interface OnItemClickListener {
        void itemClick(int position);
       // void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ViewHolder_browse extends RecyclerView.ViewHolder {
        public TextView planView, scoreView, creatorView;
        public ImageView orientationImage;

        public ViewHolder_browse(@NonNull View itemView, final OnItemClickListener listener)
        {
            super(itemView);
            planView = itemView.findViewById(R.id.planName);
            scoreView = itemView.findViewById(R.id.scoreTxt);
            orientationImage = itemView.findViewById(R.id.orientationImg);
            creatorView = itemView.findViewById(R.id.creatorTxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {   // Adds a clicklistener to the newly created cardview
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });
         /*   deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            }); */
        }
    }

    public Adapter_browse(ArrayList<Plan> entryList) {
        mEntryList = entryList;
    }

    @NonNull
    @Override
    public ViewHolder_browse onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {          // Attaches a Plan's info to a entry_browse.xml layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_browse,parent,false);
        ViewHolder_browse viewHolder = new ViewHolder_browse(v, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_browse holder, int position) {         // Inserts the newly made entry to the desired recyclerview
        Plan currentItem = mEntryList.get(position);
        holder.planView.setText(currentItem.planName);
        switch (currentItem.orientation){
            case "Technology":
                holder.orientationImage.setImageResource(R.drawable.science_icon);
                break;
            case "Culture":
                holder.orientationImage.setImageResource(R.drawable.culture_icon);
                break;
            case "Diplomacy":
                holder.orientationImage.setImageResource(R.drawable.diplmacy_icon);
                break;
            case "Conquest":
                holder.orientationImage.setImageResource(R.drawable.conquest_icon);
                break;
            default:
                holder.orientationImage.setImageResource(R.drawable.ic_delete);
                break;
        }
        holder.creatorView.setText("By: " + currentItem.creator);
        int score = Math.round(currentItem.score);
        if (score <= 51){
            holder.scoreView.setTextColor(Color.parseColor("#FA6337"));
        }
        holder.scoreView.setText((score) + "%");
    }

    @Override
    public int getItemCount() {
        return mEntryList.size();
    }
}
