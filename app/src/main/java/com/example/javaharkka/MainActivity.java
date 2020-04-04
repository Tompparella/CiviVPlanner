package com.example.javaharkka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;
    private FirebaseAuth fbAuth;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;
    private TextView txtCurrentUser, txtUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUIText();
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

    private void setUIText(){
        fbAuth = FirebaseAuth.getInstance();
        fbData = FirebaseDatabase.getInstance();
        dbRef = fbData.getReference("Users").child(fbAuth.getUid());
        txtCurrentUser = (TextView) findViewById(R.id.txtCurrentUser);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users currentuser = dataSnapshot.getValue(Users.class);
                txtCurrentUser.setText(" Logged in as " + currentuser.getUserName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,"Couldn't connect to database. Please check your connection.",Toast.LENGTH_SHORT).show();
            }
        });
        txtUid = (TextView) findViewById(R.id.txtUid);
        txtUid.setText(" UserID: " + fbAuth.getUid());
    }
}

