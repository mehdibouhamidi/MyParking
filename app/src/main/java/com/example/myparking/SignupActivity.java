package com.example.myparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    EditText signup_username, signup_email,signup_pass,signup_pass_confim,matricule;
    ImageView butlogin;
    TextView sloginBtn;
    private FirebaseAuth fAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup_username = findViewById(R.id.signup_username);
        signup_email = findViewById(R.id.signup_email);
        signup_pass = findViewById(R.id.signup_pass);
        signup_pass_confim = findViewById(R.id.signup_pass_confim);
        matricule = findViewById(R.id.matricule);
        butlogin = findViewById(R.id.butlogin);
        sloginBtn = findViewById(R.id.sloginBtn);

        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();

        sloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(myIntent);
            }
        });

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }

        butlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signup_email.getText().toString().trim();
                String password = signup_pass.getText().toString().trim();
                String password_conf = signup_pass_confim.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    signup_email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    signup_pass.setError("password is required");
                    return;
                }
                if(TextUtils.isEmpty(password_conf)){
                    signup_pass_confim.setError("password confirmation is required");
                    return;
                }
                if(password.length()<6){
                    signup_pass.setError("password must be >6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //enregistrement d'utilisateur

                fAuth.createUserWithEmailAndPassword(email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "succues", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Home.class));
                            }else{
                                Toast.makeText(SignupActivity.this, "failed", Toast.LENGTH_SHORT).show();
                            }
                    }
                });


                }

            }

        );
    }}

    
