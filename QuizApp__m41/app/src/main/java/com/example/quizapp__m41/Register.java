package com.example.quizapp__m41;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    TextView etRegEmail;
    TextView etLoginPassword;
    TextView tvLoginHere;
    Button btnRegister;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etRegEmail = (TextView) findViewById(R.id.etRegEmail);
        etLoginPassword = (TextView) findViewById(R.id.etLoginPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        tvLoginHere = (TextView) findViewById(R.id.tvLoginHere);
        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etRegEmail.getText().toString();
                String password = etLoginPassword.getText().toString();
                //String password1 = etRegPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this, "Please fill this email field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Please fill this password field", Toast.LENGTH_SHORT).show();
                    return;
                }

              /*  if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(Register.this, "Please fill this password confirm field", Toast.LENGTH_SHORT).show();
                    return;
                }*/

               if (password.length() < 6) {
                    Toast.makeText(Register.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
/*
                if (!password.equals(password1)) {
                    Toast.makeText(Register.this, "The password was not confirmed correctly", Toast.LENGTH_SHORT).show();
                    return;
                }*/

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, LoginActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }}


