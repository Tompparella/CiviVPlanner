package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class techpathmenu extends AppCompatActivity implements View.OnClickListener {

    private Button pottery,anihusb,archery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techpathmenu);

        // Finding all the tech buttons from the activity
        pottery = (Button) findViewById(R.id.potteryBtn);
        anihusb = (Button) findViewById(R.id.anihusbBtn);
        archery = (Button) findViewById(R.id.archeryBtn);

        // Setting the same onclicklistener to all the buttons to save resources while opening activity
        pottery.setOnClickListener(this);
        anihusb.setOnClickListener(this);

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
        switch (v.getId()){
            case R.id.potteryBtn:
                System.out.println("Pottery");
            case R.id.anihusbBtn:
                System.out.println("Animal Husbandry");
        }
    }
}
