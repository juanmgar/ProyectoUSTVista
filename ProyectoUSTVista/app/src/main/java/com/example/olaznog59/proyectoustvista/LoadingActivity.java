
package com.example.olaznog59.proyectoustvista;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoadingActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);







}

    public void buttonEnviarLoading (View v){
        Intent intent = new Intent (this,ContactoActivity.class);
        startActivity(intent);

        finish();

    }
}
