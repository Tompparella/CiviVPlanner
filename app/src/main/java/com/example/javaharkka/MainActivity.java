package com.example.javaharkka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    private Button btnLogout, browseBtn, aboutBtn;
    private FirebaseAuth fbAuth;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;
    private TextView txtCurrentUser, txtUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();
        try {
            setUIText();
        } catch (Exception e){
            Log.wtf("Database error: ", e);
        }
    }

    // Sets the UI's buttons to their listeners and adds functions when a button is pressed.
    // Similar methods are used in almost every activity-class of the program.

    private void setButtons(){
        browseBtn = (Button) findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Opens the plan browser activity.
                Intent intent = new Intent(MainActivity.this,BrowsePlans.class);
                startActivity(intent);
            }
        });
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
        orientation_button.setOnClickListener(new View.OnClickListener() { // Begins the plan creation process and takes the user to the orientation activity.
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrientationActivity.class);
                startActivity(intent);
            }
        });
        aboutBtn = (Button) findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Opens the in-a-nutshell-documentation of the program.
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

    // This method loads the user's data from database and sets the activity's views accordingly.

    private void setUIText(){
        fbAuth = FirebaseAuth.getInstance();
        fbData = FirebaseDatabase.getInstance();
        dbRef = fbData.getReference("Users").child(fbAuth.getUid());  // Gets a reference of the user's info from the "Users" branch of the database.
        txtCurrentUser = (TextView) findViewById(R.id.txtCurrentUser);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {  // Reads data from the reference.
                Users currentuser;
                String currentUserName, uId;
                currentuser = dataSnapshot.getValue(Users.class);
                currentUserName = currentuser.getUserName();
                txtCurrentUser.setText(" Logged in as " + currentUserName);
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

