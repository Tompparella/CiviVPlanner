    /*
    CiviVPlanner; Android Studio; Tommi Kunnari; Techpath.class;

    A recyclerview is created where all of the new plans' technologies (EntryItem)
    are listed as cardviews in rising order. The cardviews are managed by an adapter.
    The user is able to delete entries or add them by clicking on one. When clicked,
    the entry will take the user to TechPathmenu activity where it's possible to add
    more techs to the list.
    */

package com.example.javaharkka;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Techpath extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Plan plan;
    private ArrayList<EntryItem> entryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techpath);

        entryList.add(new EntryItem("Add a technology",1));

        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");

        buildRecView();
        buildButtons();

    }
    private void openTechmenu(){            // Opens the activity that allows user to add more techs to the plan.
        Intent intent = new Intent(this,Techpathmenu.class);
        intent.putExtra("plan",plan);
        startActivityForResult(intent,1);
    }
    private void openNext(){
        plan.printTechs();
        if(plan.techOrder.size() < 5){
            Toast.makeText(this, "Add at least 5 technologies before proceeding", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, Policypath.class);
            intent.putExtra("plan", plan);
            finish();
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {       // Gets the plan bac after returning from TechPathMenu activity
        if(requestCode == 1 && resultCode == RESULT_OK){
            plan = (Plan) data.getExtras().getSerializable("plan");
            entryList = plan.techOrder;
            buildRecView();
        }
    }
    private void buildRecView(){
        if(plan.techOrder.size() != 0){
            entryList = plan.techOrder;
        }
        recyclerView = findViewById(R.id.base);
        layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new Adapter(entryList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                openTechmenu();
                //changeItem(entryList,position, entryList.get(position).getTechName());
            }
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    private void removeItem(int position){  // Removes an entry from the list
        if (position == 0){
            entryList.remove(position);
            recyclerAdapter.notifyItemRemoved(position);
            if (entryList.size() == 0){
                entryList = new ArrayList<>();
                buildRecView();
                entryList.add(new EntryItem("Add a technology",1));
                return;
            }
        } else {
            entryList.remove(position);
            recyclerAdapter.notifyItemRemoved(position);
    }
        for(int i=0; i < entryList.size(); i++){
            entryList.get(i).setNumber(i+1);
            recyclerAdapter.notifyItemChanged(i);
        }
        plan.techOrder = entryList;
    }

    private void buildButtons(){
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Techpath.this, OrientationActivity.class);
                intent.putExtra("plan", plan);
                startActivity(intent);
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext();
            }
        });
    }

}
