/*
CiviVPlanner; Android Studio; Tommi Kunnari; Login.class;

A class that handles creating the Plan to be passed to following activities.
Also lets the user select the desired victory type.
*/


package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OrientationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        setViews();
    }

    private void setViews(){
        Button tech_button = findViewById(R.id.techBtn);
        Button cult_button = findViewById(R.id.cultBtn);
        Button diplo_button = findViewById(R.id.diploBtn);
        Button conq_button = findViewById(R.id.conqBtn);
        tech_button.setOnClickListener(this);
        cult_button.setOnClickListener(this);
        diplo_button.setOnClickListener(this);
        conq_button.setOnClickListener(this);

        ImageButton returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Plan plan = new Plan();
        switch (v.getId()) {
            case R.id.techBtn:
                plan.setOrientation("Technology");
                break;
            case R.id.cultBtn:
                plan.setOrientation("Culture");
                break;
            case R.id.diploBtn:
                plan.setOrientation("Diplomacy");
                break;
            case R.id.conqBtn:
                plan.setOrientation("Conquest");
                break;
        }
        openTech(plan);
    }

    private void openTech(Plan plan) {
        Intent intent = new Intent(this, Techpath.class);
        intent.putExtra("plan", plan);
        finish();
        startActivity(intent);
    }
}