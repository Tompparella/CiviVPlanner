/*
CiviVPlanner; Android Studio; Tommi Kunnari; BrowsePlans.class;

This activity loads user created Plans from the database and presents
them in a recyclerview. The entries have a ImageResource that depends
on the plan's victory condition, rating, name, and it also shows it's
creator. By clicking an entry the user is taken to the ReviewPlan
activity.
*/

package com.example.javaharkka;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BrowsePlans extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter_browse recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Plan plan;
    private ArrayList<Plan> entryList = new ArrayList<>(), tempList;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_plans);

        try {
            fbData = FirebaseDatabase.getInstance();
            dbRef = fbData.getReference("Plans");
        } catch (Exception e){
            Toast.makeText(this, "Error connecting to database",Toast.LENGTH_SHORT).show();
            Log.wtf("Database error: ",e);
            finish();
        }
        getPlans();

        buildButtons();

    }

    private void buildRecView(){
        recyclerView = findViewById(R.id.base);
        layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new Adapter_browse(entryList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new Adapter_browse.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                Plan entry = entryList.get(position);
                openPlan(entry);
            }
        });
    }

    private void buildButtons(){
        ImageButton returnButton = findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton diploBtn, conqBtn, cultBtn, scienceBtn;

        diploBtn = findViewById(R.id.diploBtn);
        conqBtn = findViewById(R.id.conqBtn);
        cultBtn = findViewById(R.id.cultBtn);
        scienceBtn = findViewById(R.id.scienceBtn);

        diploBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortVictory("Diplomacy");
                buildRecView();
            }
        });
        conqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortVictory("Conquest");
                buildRecView();
            }
        });
        cultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortVictory("Culture");
                buildRecView();
            }
        });
        scienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortVictory("Technology");
                buildRecView();
            }
        });
    }
    private void getPlans(){            // Loads Plans from the database
        System.out.println("Alkaa");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                entryList.clear();

                try {
                    while (items.hasNext()) {
                        DataSnapshot item = items.next();
                        plan = item.getValue(Plan.class);
                        entryList.add(plan);
                    }
                } catch (Exception e){
                    Log.wtf("Plans read error: ", e);
                }
                sortList();
                tempList = new ArrayList<>(entryList);
                buildRecView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed to read value.", databaseError.toException());
            }
        });
    }
    private void openPlan(Plan entry){                  // Opens the PlanReview activity and let's the user inspect the selected plan
        Intent intent = new Intent(this, PlanReview.class);
        intent.putExtra("entry", entry);
        startActivity(intent);
    }
    private void sortList(){                            // Sorts the list of plan's score-vise
        Collections.sort(entryList, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                return Float.valueOf(o2.score).compareTo(o1.score);
            }
        });
    }
    private void sortVictory(String type){              // Filter's out all plans that don't match the selected victory type.
        entryList = new ArrayList<>(tempList);
        for (int k=0; k<entryList.size();){
            if(entryList.get(k).orientation.equals(type)){
                k++;
            } else {
                entryList.remove(k);
            }
        }
    }
}
