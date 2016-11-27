package com.example.olaznog59.proyectoustvista.modelo.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.olaznog59.proyectoustvista.modelo.entidad.Contacto;

/**
 * Created by juanmgar on 22/11/16.
 */

/*Esta es la clase que guarda los contactos, los crea y los borra*/
public class AlmacenContactos {

    private DataBaseHelper db = null;
    private SQLiteDatabase sql = null;

    public AlmacenContactos(Context context){
        db = new DataBaseHelper(context);

        sql = db.getWritableDatabase();
    }

    public void cerrar(){
        db.close();
    }

    public void crearContacto(Contacto contacto){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",contacto.getNombre());
        contentValues.put("telefono",contacto.getTelefono());
        contentValues.put("latitud",contacto.getLatitud());
        contentValues.put("longitud",contacto.getLongitud());


        sql.insert(DataBaseHelper.TABLA,null,contentValues);
    }



    public Cursor obtenerContactos(){
        String [] columnasABuscar = {"_id","nombre","telefono","latitud", "longitud"};
        Cursor cursor = sql.query(DataBaseHelper.TABLA,columnasABuscar,null,null,null,null,null,null);
        return  cursor;
    }

    public boolean borrarContacto(int id){
        int i = sql.delete(DataBaseHelper.TABLA,"_id="+id,null);
        return i >0;
    }
}
