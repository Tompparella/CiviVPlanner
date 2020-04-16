package com.example.javaharkka;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrowsePlans extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter_browse recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Plan plan;
    private ArrayList<Plan> entryList = new ArrayList<>();
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_plans);

        fbData = FirebaseDatabase.getInstance();
        dbRef = fbData.getReference("Plans");

        getPlans();
        //TODO Alkioiden lisäys!!

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
                //TODO Alkion klikkaus!!
                //changeItem(entryList,position, entryList.get(position).getTechName());
            }
        });
    }

    private void buildButtons(){
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(BrowsePlans.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getPlans(){
        System.out.println("Alkaa");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                entryList.clear();
                System.out.println("Ennen looppia");
                while(items.hasNext()){
                    DataSnapshot item = items.next();
                    plan = item.getValue(Plan.class);
                    entryList.add(plan);
                    System.out.println(entryList);
                }
                buildRecView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Failed to read value.", databaseError.toException());
                Toast.makeText(BrowsePlans.this,"Couldn't connect to database. Please check your connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                Toast.makeText(BrowsePlans.this,"Number of plans: " + dataSnapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();
                while (items.hasNext()){
                    System.out.println("Kierros");
                    DataSnapshot item = items.next();
                    if (item != null) {
                        Plan plan = new Plan();
                        plan.creator = item.child("creator").getValue().toString();
                        plan.creatorId = item.child("creatorId").getValue().toString();
                        plan.description = item.child("description").getValue().toString();
                        plan.ideology = item.child("ideology").getValue().toString();
                        plan.orientation = item.child("orientation").getValue().toString();
                        plan.planName = item.child("planName").getValue().toString();
                        ArrayList<PolicyItem> temp1 = new ArrayList<>();
                        int k = 0;
                        for (DataSnapshot ds : dataSnapshot.child("policyOrder").getChildren()) {
                            PolicyItem pol = ds.child(Integer.toString(k)).getValue(PolicyItem.class);
                            k++;
                            temp1.add(pol);
                        }
                        ArrayList<EntryItem> temp2 = new ArrayList<>();
                        k = 0;
                        for (DataSnapshot ds : dataSnapshot.child("techOrder").getChildren()) {
                            EntryItem tech = ds.child(Integer.toString(k)).getValue(EntryItem.class);
                            k++;
                            temp2.add(tech);
                        }
                        plan.policyOrder = temp1;
                        plan.techOrder = temp2;
                        entryList.add(plan);
                        System.out.println(entryList);
                    } else{
                        System.out.println("Ei alkioita");
                        break;
                    }
                    i++;
                }
                System.out.println("Loppuu");
                */
