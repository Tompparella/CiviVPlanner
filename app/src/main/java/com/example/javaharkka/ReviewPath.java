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

    private ArrayList<PolicyItem> policyList = new ArrayList<>();
    private ArrayList<EntryItem> techList = new ArrayList<>();
    private boolean isTechPath; // Boolean value that decides whether the user wants to inspect policies or technologies.

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

        ImageButton returnBtn = findViewById(R.id.returnBtn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buildRecView();
    }

    private void buildRecView() {
        RecyclerView recyclerView = findViewById(R.id.base);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        TextView pathTxt = findViewById(R.id.pathTxt);
        if (isTechPath){
            Adapter_tech techAdapter = new Adapter_tech(techList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(techAdapter);
            pathTxt.setText("Tech path");
        } else {
            Adapter_policy policyAdapter = new Adapter_policy(policyList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(policyAdapter);
            pathTxt.setText("Policy path");
        }
    }
}