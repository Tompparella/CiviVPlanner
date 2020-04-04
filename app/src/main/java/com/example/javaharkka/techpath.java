package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class techpath extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techpath);

        Intent intent = getIntent();
        Plan plan = (Plan) intent.getSerializableExtra("plan");
        System.out.println(plan.orientation);

        Button firsttechButton = (Button) findViewById(R.id.firsttechButton);
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        firsttechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTechmenu();
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
    public void openTechmenu(){
        Intent intent = new Intent(this,techpathmenu.class);
        startActivity(intent);
    }
    public void openNext(){
        Intent intent = new Intent(this,policypath.class);
        startActivity(intent);
    }
}
