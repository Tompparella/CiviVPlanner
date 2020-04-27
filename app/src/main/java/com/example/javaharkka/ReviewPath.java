package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewPath extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter_tech techAdapter;
    private Adapter_policy policyAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<PolicyItem> policyList = new ArrayList<>();
    private ArrayList<EntryItem> techList = new ArrayList<>();
    boolean isTechPath;
    private ImageButton returnBtn;
    private Plan plan;
    private TextView pathTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_path);

        Intent intent = getIntent();
        isTechPath = (boolean) intent.getSerializableExtra("bool");

        if (isTechPath == true){
            techList = (ArrayList<EntryItem>) intent.getSerializableExtra("techs");
        } else {
            policyList = (ArrayList<PolicyItem>) intent.getSerializableExtra("pols");
        }

        returnBtn = (ImageButton) findViewById(R.id.returnBtn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buildRecView();
    }

    private void buildRecView() {
        recyclerView = findViewById(R.id.base);
        layoutManager = new LinearLayoutManager(this);
        pathTxt = (TextView) findViewById(R.id.pathTxt);
        if (isTechPath == true){
            techAdapter = new Adapter_tech(techList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(techAdapter);
            pathTxt.setText("Tech path");
        } else {
            policyAdapter = new Adapter_policy(policyList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(policyAdapter);
            pathTxt.setText("Policy path");
        }
    }
}