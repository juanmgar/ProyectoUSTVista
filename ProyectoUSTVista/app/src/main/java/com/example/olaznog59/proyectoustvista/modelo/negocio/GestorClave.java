package com.example.olaznog59.proyectoustvista.modelo.negocio;

/**
 * Created by juanmgar on 21/11/16.
 */

import android.content.Context;

import com.example.olaznog59.proyectoustvista.modelo.persistencia.AlmacenKey;

public class GestorClave {

    Context context;
    public GestorClave(Context context){
        this.context = context;
    }


    public boolean guardarKey(String key) {
        boolean ok = false;
        AlmacenKey ak = new AlmacenKey(context);
        ak.guardarKey(key);
        return ok;
    }

    public String getKey(){
        AlmacenKey ak = new AlmacenKey(context);
        String key = ak.obtenerKey();
        return key;
    }


}
