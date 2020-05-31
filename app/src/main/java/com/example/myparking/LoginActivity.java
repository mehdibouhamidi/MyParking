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

public class LoginActivity extends AppCompatActivity {
    ProgressBar progressBar_log;
    ImageView loginbut;
    EditText login_username,login_password;
    TextView signup;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar_log = findViewById(R.id.progressBar_log);
        loginbut = findViewById(R.id.loginbut);
        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        signup = findViewById(R.id.signup);
        fAuth = FirebaseAuth.getInstance();

        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_username.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    login_username.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    login_password.setError("password is required");
                    return;
                }

                if(password.length()<6){
                    login_password.setError("password must be >6 characters");
                    return;
                }

                progressBar_log.setVisibility(View.VISIBLE);
                //authantification d'utilisateur

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "there is no user or wrong password ", Toast.LENGTH_SHORT).show();
                            progressBar_log.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }

    public void buSignup(View view) {
        Intent mainIntent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(mainIntent);
    }
}
