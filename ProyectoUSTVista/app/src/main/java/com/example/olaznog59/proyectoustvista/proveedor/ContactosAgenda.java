package com.example.olaznog59.proyectoustvista.proveedor;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Usuario on 27/11/2016.
 */

//PARTES JUNTADAS EN UN ÚNICO PROYECTO
public class ContactosAgenda {

    private Context context;

    public ContactosAgenda(Context context) {
        this.context = context;
    }

    public String [] obtenerInfoAgenda(){
        String [] contactos = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions((Activity) context,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        100);
                contactos = cargarContactos();

            } else {
                contactos = cargarContactos();
            }
        }

        return contactos;
    }



    private String [] cargarContactos(){
        ContentResolver resolver=context.getContentResolver();

               Cursor c=resolver.query(ContactsContract.Data.CONTENT_URI,
                              null,
                     Data.MIMETYPE+"='"+ Phone.CONTENT_ITEM_TYPE+"'",
                    null,
                   null);

        String[] contactos={Phone.DISPLAY_NAME, Phone.NUMBER};
        return contactos;
    }


    public String [] obtenerNumeros(){

        String [] contactos = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions((Activity) context,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        100);
                contactos = cargarNumeros();

            } else {
                contactos = cargarNumeros();
            }
        }

        return contactos;
    }


    private String [] cargarNumeros(){


        ContentResolver resolver=context.getContentResolver();

        Cursor c=resolver.query(ContactsContract.Data.CONTENT_URI,
                null,
                Data.MIMETYPE+"='"+ Phone.CONTENT_ITEM_TYPE+"'",
                null,
                null);

        String[] contactos={Phone.NUMBER};

        return contactos;


    }

}
