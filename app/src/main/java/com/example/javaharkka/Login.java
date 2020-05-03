package com.example.javaharkka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends AppCompatActivity {

    private TextView userRegister;
    private FirebaseAuth fbAuth;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;
    private EditText userEmail, userPswrd;
    private Button btnLogin;
    private String fileName = "userInfo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        userEmail = (EditText) findViewById(R.id.etEmail);
        userPswrd = (EditText) findViewById(R.id.etPassword);

        fbAuth = FirebaseAuth.getInstance();
        fbData = FirebaseDatabase.getInstance();
        dbRef = fbData.getReference("Users/"+fbAuth.getUid());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        FirebaseUser user = fbAuth.getCurrentUser();
        if(user != null){                                       // If the user is already logged in, he/she's taken to the verification screen without logging in again.
            dbRef.child("userName").addValueEventListener(new ValueEventListener() {    // Gets a reference of the username from the "Users" branch of the database.
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String userName = dataSnapshot.getValue(String.class);
                    System.out.println("Database: " + userName);
                    writeUserInfo(fbAuth.getUid(), userName);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    System.out.println("Problem while reading from database.");
                }
            });
                finish();
                startActivity(new Intent(Login.this, Verification.class));
        }
        userRegister = (TextView) findViewById(R.id.txtRegister);
        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
    }
    private void openRegisterActivity(){
        startActivity(new Intent(Login.this, Register.class));
    }

    private void login(){    // Checks whether the user's credentials are correct.
        String email, password;
        email = userEmail.getText().toString();
        password = userPswrd.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(Login.this,"Enter your credentials",Toast.LENGTH_SHORT).show();
        } else {
            fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {                              // If logging in is successful, the user's info is written to a local file and the user is taken to the next activity.
                        dbRef.child("userName").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String userName = dataSnapshot.getValue(String.class);
                                System.out.println("Database: " + userName);
                                writeUserInfo(fbAuth.getUid(), userName);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                System.out.println("Problem while reading from database.");
                            }
                        });
                            Toast.makeText(Login.this, "Logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, Verification.class));
                            finish();

                    } else {
                        Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /*  This next method writes the current user's information to a local file in csv format.
    The file format is "Username, UserId, Voted plans (to be added later)".
    It's not that necessary for the program's functioning, but it's a requirement
    to pass this as my final project, so it had to be added.     */

    private void writeUserInfo(String uId, String userName){
        String text = uId + "," + userName + ", ,";
        FileOutputStream fs;
        try {
            fs = openFileOutput(fileName, MODE_PRIVATE);
            fs.write(text.getBytes());
            fs.close();
        } catch (FileNotFoundException e){
            Log.wtf("File error: ",e);
            finish();
        } catch (IOException e){
            Log.wtf("File error: ",e);
            finish();
        }/* finally {
            testRead();
        }*/
    }

    // A method to check whether the file was created successfully. Used in debugging, which is why it's commented out.

    /* private void testRead() {
        String text;
        try {
            FileInputStream fs = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            while((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            System.out.println(sb.toString());
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    } */

}
