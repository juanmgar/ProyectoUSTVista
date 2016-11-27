package com.example.olaznog59.proyectoustvista.patronSingleton;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/11/2016.
 */

//

//CONSTRUCTOR CON LOS PARÁMETROS QUE NECESITAMOS PARA SOLICITAR AL SERVIDOR
    //Y POR ÚLTIMO LOS "MATCHES" QUE SE PODRÁN MODIFICAR A POSTERIORI

public class Claves {
    private static Claves instance = null;
    private String phone;
    private String  key;
    private int errorCode;
    private ArrayList<String> matches;

    public Claves(String phone, String key) {
        this.phone = phone;
        this.key = key;
    }

    public static Claves getInstance(String phone, String key){
        if (instance == null){
            instance = new Claves(phone,key);
        } else {
            Log.d("PatrónSingleton","Instancia ya creadada");
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
}
