package com.example.myparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myparking.model.Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainReservation extends AppCompatActivity {
    RecyclerView reservationList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reservation);

        reservationList= findViewById(R.id.reservationList);
        //get the back button bar in the toolbar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //and after that generate the method to use the button when you click in it the method called "onOptionItemSelected" and make condition if the user click


        List<String> parking = new ArrayList<>();
        List<String> time = new ArrayList<>();
        List<String> day = new ArrayList<>();
        List<String> price = new ArrayList<>();

        ///juste des exemples pour des reservations il faut les remplacer par des données de la firebase apres note : attention le nombre de donnee ajoutee doit etre le meme
        parking.add("park 1");
        time.add("21:14:33");
        day.add("45/12/2021");
        price.add("25 dh");

        parking.add("park 2");
        time.add("08:20:33");
        day.add("01/12/2021");
        price.add("7 dh");

        parking.add("park 1");
        time.add("21:14:33");
        day.add("3/07/2021");
        price.add("2 dh");
        ////////cece en haut est juste un exemple , ensuite il faut instancier la class adapter que nous avons créer
        adapter = new Adapter(parking,time,day,price);
        reservationList.setLayoutManager(new LinearLayoutManager(this));//pour les cardView sous forme de ligne
        //reservationList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//POUR 2COLONNE
        reservationList.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainReservation.this,"Sauvegarder",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(view.getContext(),AddReservations.class));
            }
        });
    }


    }

