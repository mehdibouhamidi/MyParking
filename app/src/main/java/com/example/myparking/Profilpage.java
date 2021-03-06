package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Profilpage extends AppCompatActivity {


    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    TextView email_pic ,username_pic,matricule_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilpage);

        email_pic = findViewById(R.id.email_pic);
        username_pic = findViewById(R.id.username_pic);
        matricule_pic = findViewById(R.id.matricule_pic);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("Utilisateurs").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                email_pic.setText(documentSnapshot.getString("email"));
                username_pic.setText(documentSnapshot.getString("username"));
                matricule_pic.setText(documentSnapshot.getString("matricule"));
            }
        });
    }}
/* /*  FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    TextView email_pic ,username_pic,matricule_pic;*/


   /*     email_pic = findViewById(R.id.email_pic);
        username_pic = findViewById(R.id.username_pic);
        matricule_pic = findViewById(R.id.matricule_pic);

        fAuth =FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId =fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("Utilisateurs").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                email_pic.setText(documentSnapshot.getString("email"));
                username_pic.setText(documentSnapshot.getString("username"));
                matricule_pic.setText(documentSnapshot.getString("matricule"));
            }
        });*/

