/*
CiviVPlanner; Android Studio; Tommi Kunnari; Register.class;

This class handles registering new users to database. It also handles
user password requirements and validates user input.
*/

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regBtn;
    private TextView userLogin;
    private FirebaseAuth fbAuth;
    private String name, userpswrd, useremail;
    private FirebaseDatabase fbData;
    private DatabaseReference dbRef;
    private Users userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupUI();
        fbAuth = FirebaseAuth.getInstance();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    register();
                }
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
        }
    private void setupUI(){
        userName = findViewById(R.id.etUsername);
        userPassword = findViewById(R.id.etPassword);
        userEmail = findViewById(R.id.etEmail);
        regBtn = findViewById(R.id.btnRegister);
        userLogin = findViewById(R.id.txtLogin);
     }
     private void register(){
         String user_mail = userEmail.getText().toString().trim();
         String user_password = userPassword.getText().toString().trim();
         fbAuth.createUserWithEmailAndPassword(user_mail,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     addUser();
                     Toast.makeText(Register.this, "Registration succesful!",Toast.LENGTH_SHORT).show();
                     finish();
                 } else {
                     Toast.makeText(Register.this, "Registration failed",Toast.LENGTH_SHORT).show();
                 }
             }
         });
     }

     private boolean validate() {   // Checks if users input is sufficient.
     boolean result = false;
     name = userName.getText().toString();
     userpswrd = userPassword.getText().toString();
     useremail = userEmail.getText().toString();
     if(name.isEmpty() || userpswrd.isEmpty() || useremail.isEmpty()){
         Toast.makeText(this,"Please verify that you entered the info correctly.", Toast.LENGTH_SHORT).show();
     } else {
         boolean number = false, capital = false, lower = false;
         for (int i=0;i<userpswrd.length();i++){   // Checks if password input includes a capital- and lower letter, and a number
             char currentChar = userpswrd.charAt(i);
             if (Character.isLowerCase(currentChar)){
                 lower = true;
             } else if (Character.isUpperCase(currentChar)){
                 capital = true;
             } else if (Character.isDigit(currentChar)){
                 number = true;
             }
         }
         if (userpswrd.matches(".*[!#¤%&/()=?*].*") && lower && capital && number && (userpswrd.length() >= 12)){ // Checks if password input contains a symbol and if the aforementioned conditions are fulfilled
             result = true;
         } else{
             Toast.makeText(this,"Make sure that your password follows the given guidelines.", Toast.LENGTH_SHORT).show();
         }
     }
     return result;
    }

    private void addUser(){     // In this method, the new user is added to the database 'Users' node's children.
        fbData = FirebaseDatabase.getInstance();
        dbRef = fbData.getReference().child("Users");
        userData = new Users(name, useremail);
        try{
            System.out.println("Homma alkaa");
            dbRef.child(fbAuth.getUid()).setValue(userData);
            System.out.println("Homma loppuu");
        } catch(Exception e){
            Log.wtf("File IO error: ",e);
        }
    }
}
