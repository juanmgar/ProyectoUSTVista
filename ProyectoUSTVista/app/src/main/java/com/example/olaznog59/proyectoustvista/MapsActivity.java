package com.example.olaznog59.proyectoustvista;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMyLocationButtonClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnMarkerClickListener{

    private static final LatLng SEGORBE = new LatLng(39.853639, -0.481421);
    private static final LatLng VALENCIA = new LatLng(39.469394, -0.376348);
    private static final LatLng BENICASSIM = new LatLng(40.054156, 0.064043);
    private static final LatLng GANDIA = new LatLng(38.970522, -0.182321);
    private static final LatLng CADIZ = new LatLng(36.506462, -6.274559);

    private GoogleMap mMap;
    //Creamos una constante para solicitar los permisos.
    //Utilizaremos esta constante en el método "onRequestPermissionResult"
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    //Booleano que nos indica cuándo un permiso ha sido denegado en el "onRequestPermissionResult"
    private boolean mPermissionDenied = false;

    private Marker mSegorbe;
    private Marker mValencia;
    private Marker mBenicassim;
    private Marker mGandia;
    private Marker mCadiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mapa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Eliminamos el titulo de la aplicacion

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void buttonEnviarMapa (View v){
        Intent intent = new Intent (this,LoginActivity.class);
        startActivity(intent);

        finish();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Ha pulsado 'Settings'", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ContactoActivity.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }




        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            setUpMap();

            mMap.setOnMyLocationButtonClickListener(this);
            enableMyLocation();
        }

    //Habilita la capa de "My Location" si "ACCESS_FINE_LOCATION" ha sido concedido.
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //Permiso para acceder a la localización perdido
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            //Acceso a localización concedido
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            //Habilita la capa de "My Location" si los permisos hasn sido concedidos
            enableMyLocation();
        } else {
            //Muestra en el monitor los permisos no concedidos cuando los fragmentos se reanuden
            mPermissionDenied = true;
        }
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            //Permisos denegado, mostramos el error en el monitor
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "Actualiza posición", Toast.LENGTH_SHORT).show();
        //Devuelve false así que no consumimos el evento y sigue estando el comportamiento por defecto
        //(El "Camera Animates" va a la posisción actual del usuario)
        return false;
    }

    private String telefono;

    //Cuando hagamos "click" en un Marker, se lanzará este método
    @Override
    public boolean onMarkerClick(Marker marker) {

        String nombre = marker.getTitle();

        //Compara el título del marker y le asigna el teléfono correspondiente
        if(nombre.equalsIgnoreCase("Ricard")){
            telefono = "tel://651885373";
            llamar();
        } else if (nombre.equalsIgnoreCase("Juanma")){
            telefono = "tel://696101266";
            llamar();
        } else if (nombre.equalsIgnoreCase("Pablo")) {
            telefono = "tel://647672169";
            llamar();
        } else if (nombre.equalsIgnoreCase("Gonzalo")) {
            telefono = "tel://664392694";
            llamar();
        } else if (nombre.equalsIgnoreCase("María")) {
            telefono = "tel://653779202";
            llamar();
        }

        return false;
    }

    //Este método llama al contacto correspondiente
    public void llamar (){

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telefono));
        startActivity(intent);
    }

    private void setUpMap() {
        mMap.setOnMarkerClickListener(this);

        mSegorbe = mMap.addMarker(new MarkerOptions()
                .position(SEGORBE)
                .title("Pablo")
                .snippet("Trabajador en Segorbe, Castellón")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));

        mValencia = mMap.addMarker(new MarkerOptions()
                .position(VALENCIA)
                .title("Gonzalo")
                .snippet("Trabajador en Valencia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));

        mBenicassim = mMap.addMarker(new MarkerOptions()
                .position(BENICASSIM)
                .title("Ricard")
                .snippet("Trabajador en Benicassim, Castellón")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));

        mGandia = mMap.addMarker(new MarkerOptions()
                .position(GANDIA)
                .title("María")
                .snippet("Trabajadora en Gandía, Valencia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));

        mCadiz = mMap.addMarker(new MarkerOptions()
                .position(CADIZ)
                .title("Juanma")
                .snippet("Trabajador en Cádiz")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
    }

}
