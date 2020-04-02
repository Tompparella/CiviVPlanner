package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class orientationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        Button tech_button = (Button) findViewById(R.id.techButton);
        Button cult_button = (Button) findViewById(R.id.cultButton);
        Button diplo_button = (Button) findViewById(R.id.diploButton);
        Button conq_button = (Button) findViewById(R.id.conqButton);
        tech_button.setOnClickListener(this);
        cult_button.setOnClickListener(this);
        diplo_button.setOnClickListener(this);
        conq_button.setOnClickListener(this);

        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.techButton:
                break;
            case R.id.cultButton:
                break;
            case R.id.diploButton:
                break;
            case R.id.conqButton:
                break;
        }
        openTech();
    }

    public void openTech() {
        Intent intent = new Intent(this, techpath.class);
        startActivity(intent);
    }
}