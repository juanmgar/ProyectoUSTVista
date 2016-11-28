package com.example.olaznog59.proyectoustvista.modelo.persistencia;

/**
 * Created by juanmgar on 21/11/16.
 */


import android.content.Context;
import android.util.Log;
<<<<<<< HEAD

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
=======
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
>>>>>>> origin/master

public class AlmacenKey{

    Context context;
    private static final String FICHERO = "key.txt";

    public AlmacenKey(Context context){
        super();
        this.context = context;
    }

    public void guardarKey(String key){
        FileOutputStream fos = null;
        PrintStream out = null;
        try {
            fos = context.openFileOutput(FICHERO, Context.MODE_APPEND);
            out = new PrintStream(fos);
            out.println(key);
            out.flush();
        }catch (Exception e){
            Log.e("AlmacenKey","Error al abrir el archivo");
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    public String obtenerKey() {

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String key = null;
        try {
            fis = context.openFileInput(FICHERO);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            key = br.readLine();

        } catch (Exception e) {
            Log.e("AlmacenKey", "Error al leer la key");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return key;
    }








}

