package com.example.olaznog59.proyectoustvista.patronSingleton;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Usuario on 28/11/2016.
 */

public class Clave {
    private static Clave instance = null;
    private String phone;
    private String  key;
    private int errorCode;
    private String descriptionCode;
    private ArrayList<String> matches;

    private Clave() {
        Log.d("Clave","Creado objeto Clave");
    }

    public void inicialice(String phone, String key){
        this.phone = phone;
        this.key = key;
    }

    public static Clave getInstance(){
        if (instance == null){
            instance = new Clave();
        } else {
            Log.d("PatrónSingleton","Instancia ya creada");
        }
        return instance;
    }

    public String getPhone() {
        return phone;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<String> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<String> matches) {
        this.matches = matches;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescriptionCode() {
        return descriptionCode;
    }

    public void setDescriptionCode(String descriptionCode) {
        this.descriptionCode = descriptionCode;
    }
}
