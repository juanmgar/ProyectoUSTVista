package com.example.olaznog59.proyectoustvista.proveedor;

/**
 * Created by Usuario on 27/11/2016.
 */

public class ContactosAgenda {

    /*
    *----------PERMISOS A SOLICITARLE AL USUARIO
    * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_CONTACTS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        100);
                cargarContactos();

            } else {
                cargarContactos();
            }
        }

      MÉTODO PARA COJER LOS CONTACTOS---------------------

        public void cargarContactos(){
        ContentResolver resolver=this.getContentResolver();

        Cursor c=resolver.query(Data.CONTENT_URI,
                null,
                Data.MIMETYPE+"='"+Phone.CONTENT_ITEM_TYPE+"'",
                null,
                null);
---------------- EN LA PRIMERA PETICIÓN SÓLO COJEREMOS LOS NÚMEROS DE TELEFONO
-------------HABRÁ SEGUNDA PETICIÓN PARA CONTRSTAR NÚMEROS Y SABER LOS NOMBRES DE LOS USUARIOS REPRESENTADOS
        String[] nombres={Phone.DISPLAY_NAME,Phone.NUMBER};

        int[] ids={android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adp = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,
                c,
                nombres,
                ids,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        ListView lvContactos=(ListView)this.findViewById(R.id.lvContactos);
            lvContactos.setAdapter(adp);
    }



        */
}
