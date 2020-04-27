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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class techpath extends AppCompatActivity {

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
        System.out.println(plan.orientation);

        buildRecView();
        buildButtons();

    }
    public void openTechmenu(){
        Intent intent = new Intent(this,techpathmenu.class);
        intent.putExtra("plan",plan);
        startActivityForResult(intent,1);
    }
    public void openNext(){
        plan.printTechs();
        if(plan.techOrder.size() < 5){
            Toast.makeText(this, "Add at least 5 technologies before proceeding", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, policypath.class);
            intent.putExtra("plan", plan);
            finish();
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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

    public void removeItem(int position){
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
                Intent intent = new Intent(techpath.this, orientationActivity.class);
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

// Deleted lines of code


    /* public void changeItem(int position, String text){
        entryList.get(position).changeText(text);
        recyclerAdapter.notifyItemChanged(position);
    }

    public void addItem(EntryItem item){
        entryList.add(new EntryItem(item.getTechName(),item.getNumber()));
    }

    firsttechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTechmenu();
            }
        });
          /* public void addButton(int i){
        if(findViewById(R.id.firsttechButton) != null){

        }
        LinearLayout base = (LinearLayout) findViewById(R.id.base);
        newBtn = new Button(this);
        newBtn.setText(String.valueOf(i+1) + ". " + plan.getTech(i));
        base.addView(newBtn);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTechmenu();
            }
        });
    } */
