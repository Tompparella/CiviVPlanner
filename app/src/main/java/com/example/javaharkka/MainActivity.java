package com.example.javaharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;
    private FirebaseAuth fbAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbAuth = FirebaseAuth.getInstance();
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                fbAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
        Button orientation_button = (Button) findViewById(R.id.Newplan);
        orientation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrientation();
            }
        });
    }

    public void openOrientation(){
        Intent intent = new Intent(this,orientationActivity.class);
        startActivity(intent);
    }

}

