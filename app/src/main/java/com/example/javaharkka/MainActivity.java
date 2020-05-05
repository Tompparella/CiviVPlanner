    /*
    CiviVPlanner; Android Studio; Tommi Kunnari; MainActivity.class;

    This is the main menu after logging in. It has
    buttons that begin different processes within
    the app. It also reads the user's id and user-
    name from the database.
    */

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

    private FirebaseAuth fbAuth;
    private TextView txtCurrentUser;

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
        Button browseBtn = findViewById(R.id.browseBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowse();
            }
        });
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        Button orientation_button = findViewById(R.id.Newplan);
        orientation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewPlan();
            }
        });
        Button aboutBtn = findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }
    private void openAbout(){
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    private void openNewPlan(){
        Intent intent = new Intent(MainActivity.this,OrientationActivity.class);
        startActivity(intent);
    }
    private void openBrowse(){
        Intent intent = new Intent(MainActivity.this,BrowsePlans.class);
        startActivity(intent);
    }
    private void logout(){
        try {
            fbAuth.signOut();
            finish();
            Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, Login.class));
        } catch (Exception e){
            Log.wtf("Database error:", e);
        }
    }

    // This method loads the user's data from database and sets the activity's views accordingly.

    private void setUIText(){
        fbAuth = FirebaseAuth.getInstance();
        FirebaseDatabase fbData = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = fbData.getReference("Users").child(fbAuth.getUid());  // Gets a reference of the user's info from the "Users" branch of the database.
        txtCurrentUser = findViewById(R.id.txtCurrentUser);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {  // Reads data from the reference.
                Users currentuser;
                String currentUserName;
                currentuser = dataSnapshot.getValue(Users.class);
                currentUserName = currentuser.getUserName();
                txtCurrentUser.setText(" Logged in as " + currentUserName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Disconnected user");
            }
        });
        TextView txtUid = findViewById(R.id.txtUid);
        txtUid.setText(" UserID: " + fbAuth.getUid());
    }
}

