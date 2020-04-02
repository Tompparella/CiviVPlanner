package com.example.javaharkka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regBtn;
    private TextView userLogin;
    private FirebaseAuth fbAuth;

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
                    String user_mail = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    fbAuth.createUserWithEmailAndPassword(user_mail,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registration succesful!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Login.class));
                            } else {
                                Toast.makeText(Register.this, "Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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
        userName = (EditText) findViewById(R.id.etUsername);
        userPassword = (EditText) findViewById(R.id.etPassword);
        userEmail = (EditText) findViewById(R.id.etEmail);
        regBtn = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.txtLogin);
     }

     private Boolean validate() {
     Boolean result = false;
     String name = userName.getText().toString();
     String userpswrd1 = userPassword.getText().toString();
     String userpswrd2 = userEmail.getText().toString();
     if(name.isEmpty() && userpswrd1.isEmpty() && userpswrd2.isEmpty()){
         Toast.makeText(this,"Please verify that you entered the info correctly.", Toast.LENGTH_SHORT);
     } else {
         result = true;
     }
     return true;
    }
}
