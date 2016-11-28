
package com.example.olaznog59.proyectoustvista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LoadingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Eliminamos el titulo de la aplicacion

        getSupportActionBar().setDisplayShowTitleEnabled(false);






    }

    public void buttonEnviarLoading (View v){
        Intent intent = new Intent (this,MapsActivity.class);
        startActivity(intent);

        finish();

    }
}
