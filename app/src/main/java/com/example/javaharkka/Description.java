/*
CiviVPlanner; Android Studio; Tommi Kunnari; Description.class;

This activity let's the user determine a description, or a guide
for their plan. It must be between 20-1000 characters long.
*/

package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Description extends AppCompatActivity {
    private Plan plan;
    private EditText dTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");

        setButtons();

        dTxt = findViewById(R.id.descriptionTxt);

    }
    private void openNext(){
        if ((dTxt.getText().toString().length() > 20) && dTxt.getText().toString().length() < 1000) {
            plan.description = dTxt.getText().toString();
            plan.printTechs();
            Intent intent = new Intent(Description.this, Planname.class);
            intent.putExtra("plan", plan);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Description must be between 20-1000 characters long.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setButtons(){
        ImageButton returnButton = findViewById(R.id.returnButton);
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNext();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Description.this, Policypath.class);
                intent.putExtra("plan", plan);
                finish();
                startActivity(intent);
            }
        });
    }
}
