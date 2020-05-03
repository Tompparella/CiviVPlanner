package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Verification extends AppCompatActivity {

    private TextView codeTxt;
    private EditText codeEdit;
    private Button submitBtn;
    private String verification_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        setViews();
    }
    private void setViews(){
        codeTxt = (TextView) findViewById(R.id.codeTxt);
        verification_code = getRandString();
        codeTxt.setText(verification_code);

        codeEdit = (EditText) findViewById(R.id.codeEdit);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
            }
        });

    }
    private void verify(){
        if (verification_code.equals(codeEdit.getText().toString())){
            Toast.makeText(Verification.this, "Correct authentication code!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Verification.this,MainActivity.class);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(Verification.this, "Incorrect authentication code.", Toast.LENGTH_SHORT).show();
        }
    }

    private String getRandString(){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        while (sb.length() < 6){
            int i = (int) (rand.nextFloat() * chars.length());
            sb.append(chars.charAt(i));
        }
        return sb.toString();
    }
}
