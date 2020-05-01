package com.example.javaharkka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Planname extends AppCompatActivity {
    private EditText planName;
    private Plan plan;
    private FirebaseAuth fbAuth;
    private FirebaseDatabase fbData;
    private DatabaseReference userRef, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planname);

        Intent intent = getIntent();
        plan = (Plan) intent.getSerializableExtra("plan");

        try {
            fbAuth = FirebaseAuth.getInstance();
            fbData = FirebaseDatabase.getInstance();
            setCreator();
        } catch(Exception e){
            openDialog();
            Toast.makeText(this, "Couldn't connect to database", Toast.LENGTH_SHORT).show();
            moveBack();

        }

        buildButtons();
        planName = (EditText) findViewById(R.id.planName);

    }
    public void submit() {
        int length = planName.getText().toString().length();
        if (length > 5 && length < 20) {
            plan.planName = planName.getText().toString();
            try {
                sendPlan();
                Intent intent = new Intent(Planname.this, MainActivity.class);
                finish();
                startActivity(intent);
            } catch (Exception e){
                System.out.println(e);
                return;
            }
        } else {
            Toast.makeText(this, "Name must be between 5 to 20 characters long", Toast.LENGTH_SHORT).show();
        }
    }
    private void buildButtons(){
        ImageButton returnButton = (ImageButton) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveBack();
            }
        });
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    submit();
                } catch (Exception e){
                    openDialog();
                    System.out.println(e);
                    return;
                }
            }
        });
    }
    private void sendPlan(){
        plan.printTechs();
        try {
            dbRef = fbData.getReference().child("Plans");
            dbRef.child(plan.planName).setValue(plan);
            Toast.makeText(Planname.this, "Plan submitted!", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
                    Toast.makeText(Planname.this,"Couldn't connect to database. Please check your connection.",Toast.LENGTH_SHORT).show();
                    System.out.println(e);
        }
    }

    private void setCreator(){
        userRef = fbData.getReference("Users").child(fbAuth.getUid());
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users currentuser = dataSnapshot.getValue(Users.class);
                plan.creator = currentuser.userName;
                plan.creatorId = fbAuth.getUid();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Planname.this,"Couldn't connect to database. Please check your connection.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialog(){
        DialogBox dialog = new DialogBox();
        dialog.show(getSupportFragmentManager(), "Example dialog");
    }
    public void moveBack(){
        Intent intent = new Intent(Planname.this, Description.class);
        intent.putExtra("plan", plan);
        finish();
        startActivity(intent);
    }
}
