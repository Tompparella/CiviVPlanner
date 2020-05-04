    /*
    CiviVPlanner; Android Studio; Tommi Kunnari; ReviewPath.class;

    This activity class presents the user with a plans' technology- or
    policy path. This depends on what boolean value is passed from previous
    activity.
    */

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
    private boolean isTechPath; // Boolean value that decides whether the user wants to inspect policies or technologies.
    private ImageButton returnBtn;
    private TextView pathTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_path);

        Intent intent = getIntent();
        isTechPath = (boolean) intent.getSerializableExtra("bool");

        if (isTechPath){        // Set the view accordingly
            techList = (ArrayList<EntryItem>) intent.getSerializableExtra("techs");
        } else {
            policyList = (ArrayList<PolicyItem>) intent.getSerializableExtra("pols");
        }

        returnBtn = findViewById(R.id.returnBtn);
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
        pathTxt = findViewById(R.id.pathTxt);
        if (isTechPath){
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