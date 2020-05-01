package com.example.javaharkka;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_policy extends RecyclerView.Adapter<Adapter_policy.ViewHolder> {

    private ArrayList<PolicyItem> mEntryList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView entryView, numView;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            entryView = itemView.findViewById(R.id.entryName);
            numView = itemView.findViewById(R.id.number);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public Adapter_policy(ArrayList<PolicyItem> entryList) {
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
        PolicyItem currentItem = mEntryList.get(position);
        holder.entryView.setText(currentItem.getPolicyName());
        holder.numView.setText(String.valueOf(currentItem.getNumber()));
        switch (currentItem.getType()){
            case 1: // Tradition
                holder.cardView.setCardBackgroundColor(Color.parseColor("#F2E0D4"));
                break;
            case 2: // Liberty
                holder.cardView.setCardBackgroundColor(Color.parseColor("#FFF3CA"));
                break;
            case 3: // Honor
                holder.cardView.setCardBackgroundColor(Color.parseColor("#F9D1C4"));
                break;
            case 4: // Piety
                holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case 5: // Patronage
                holder.cardView.setCardBackgroundColor(Color.parseColor("#D3DDEC"));
                break;
            case 6: // Aesthetics
                holder.cardView.setCardBackgroundColor(Color.parseColor("#FCC9FD"));
                break;
            case 7: // Commerce
                holder.cardView.setCardBackgroundColor(Color.parseColor("#F7FFBA"));
                break;
            case 8: // Exploration
                holder.cardView.setCardBackgroundColor(Color.parseColor("#C7FFBA"));
                break;
            case 9: // Rationalism
                holder.cardView.setCardBackgroundColor(Color.parseColor("#CBF5FF"));
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mEntryList.size();
    }
}
