package com.example.olaznog59.proyectoustvista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.olaznog59.proyectoustvista.LoginActivity;

/**
 * Created by olaznog59 on 25/11/2016.
 */

public class SplashActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        finish();
    }

}
