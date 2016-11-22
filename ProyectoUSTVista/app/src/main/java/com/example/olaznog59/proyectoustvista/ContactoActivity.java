package com.example.olaznog59.proyectoustvista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void buttonEnviarContacto (View v){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);

        finish();

    }

}
