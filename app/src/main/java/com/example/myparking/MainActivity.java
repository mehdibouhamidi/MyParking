package com.example.myparking;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**première classe pour affichage de la page d'entrée "splash_screen" pendant 3s*/
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after 5 seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Creer un Intent pour commencer la deuxieme activity. */
                Intent mainIntent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }

        }, SPLASH_DISPLAY_LENGTH);

    }
}
