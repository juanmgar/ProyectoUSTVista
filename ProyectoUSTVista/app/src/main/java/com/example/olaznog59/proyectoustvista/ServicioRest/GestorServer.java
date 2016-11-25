package com.example.olaznog59.proyectoustvista.ServicioRest;



import android.util.Log;

import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToGetContacts;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToGetCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToRegister;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToSendCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.GetCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Matches;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Register;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.SendCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.UsuariosRest;
import com.example.olaznog59.proyectoustvista.patronSingleton.Claves;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Usuario on 24/11/2016.
 */

public class GestorServer {

    public static final String url = "[IP]:[PUERTO]/talentum_geo/rest/services/";
    public static final String TAG = "ServicioREST";
    private Claves claves;
    private int codMatches = -1;
    private int codSendCoord = -1;
    ArrayList<UsuariosRest> arrayList;

    //CREO QUE LO MEJOR ES QUE DE MOMENTO DEVUELVA UN CÓDIGO
    //EN LA CLASE "MAIN" EN FUNCIÓN DEL CÓDIGO RECIBIDO:
        //-1 -> SIGNIFICA QUE NO HA HABIDO CONEXIÓN
        // 0 -> QUE LA CONEXIÓN SE HA REALIZADO CON ÉXITO Y DEBE PASAR A LA SIGUIENTE PANTALLA  Ó
            // RECIBIR EL CÓDIGO Y ENVIAR LA SIGUIENTE PETICIÓN AL SERVIDOR - CON LA CLASE "CLAVES" INSTANCIADA
            //Y ALLÍ TAMBIÉN COJEREMOS LOS VALORES DEL OBJETO "CLAVES" Y LOS ALMACENAREMOS EN LA SHARED PREFERENCES
        // 1,2,3 ... -> DEBERÁ PERMANECER EN LA PÁGINA DE LOGIN, PARA QUE SE VUELVA A INTRODUCIR TLF Y VUELVA A HACER PETICIÓN
    public Claves obtenerIdUsuario(String telefono){
        Log.d(TAG + " Obtener id","Vamos a registrar el tlf: "+telefono);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url) //URL A CONECTARSE
                .addConverterFactory(GsonConverterFactory.create()) //FORMATO DE "SERIALIZACIÓN"
                .build();

        ServicioRest service = retrofit.create(ServicioRest.class); //OBJETO DE LA INTERFAZ

        final ToRegister register = new ToRegister(); //OBJETO A SERIALIZAR PARA EL "BODY"
        register.setPhone(telefono);
        Log.d(TAG + " Obtener id","Se ha generado el objeto 'ToRegister': "+register.toString());

        Call<Register> call = service.getId(register); //MÉTODO A LLAMAR
        call.enqueue( new Callback<Register>() {
            //el método "enqueue" hace la llamada "asynchronous"
            @Override
            public void onResponse(Call call, Response response) {
                Log.d(TAG + " Obtener id","Se ha realizado la llamada con éxito, el objeto recibido: "+response.body().toString());
                Register reg = (Register) response.body();
//-----------------------------------------------------------------------------------------------------
                //EN CASO DE NO INSTANCIAR EL OBJETO "claves" NO SE VA A PODER ACCEDER A ÉSTE CÓDIGO.... :-(  ???
                //SE CREA UNA REFERENCIA, AUN QUE NO SE INICIALICE, AL TENER LOS PARÁMETROS CON GETTER Y SETTER,
                // PODRÍAMOS ACCEDER A ELLOS SIN HACER NEW???????????
                //ENTIENDO ------ QUE HE HECHO LA CLASE PARA QUE NO SE PUEDA MODIFICAR EL VALOR DEL TLF Y LA KEY ----- ????
                claves.setErrorCode(reg.getErrorCode()); //CODIGO DE ERROR RECIBIDO
//-----------------------------------------------------------------------------------------------------
                if (reg.getErrorCode()==0){
                    //AQUÍ TENDREMOS QUE GUARDAR EL TLF Y LA KEY EN SHARED PREFERENCES Y INICIAR EL OBJETO "CLAVES"
                    claves = Claves.getInstance(register.getPhone(), //OBJETO QUE MANDAMOS PARA HACER LA LLAMADA
                            reg.getKey()); //OBJETO QUE RECIBIMOS
                } else {
                    //Aquí deberíamos mostrar un toast, posiblemente mandando un código a la pantalla para que vuelva a pedir el telefono.
                    Log.d(TAG + "Obtener id","Ha habido un error en el registro: "+reg.getErrorDescription());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d(TAG + " Obtener id","Ha fallado la conexión con el servidor: "+t.getMessage());
            }
        });

        return claves;
    }

    //COMO EL OBJETO CLAVES LO NECESITAMOS EN ÉSTA CLASE, LO GENERAREMOS AQUÍ
    //CADA VEZ QUE INICIALICEMOS EL PROGRAMA PEDIREMOS LOS "MATCHES" AL SERVIDOR, POR TANTO,
    //CONFIGURAMOS PARA QUE CUANDO SOLICITEMOS LOS MATCHES SE GENERE EL OBJETO CLAVES

//---------------------------------TAREA SÍNCRONA???-------------------------------------------
    //CÓMO ESPERAMOS EN "MAIN" A LA RESPUESTA DEL SERVIDOR SINO???????
    public int obtenerMatches (final Claves claves, ArrayList<String> contacts){

        this.claves = claves;
        Log.d(TAG + " MATCHES","Vamos a solicitar los usuarios registrados en la app P: "+claves.getPhone());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicioRest servicioRest = retrofit.create(ServicioRest.class);

        Log.d(TAG + " MATCHES","Creado ServicioRest y Retrofit");
        //generamos objeto solicitado por el servidor
        ToGetContacts toGetContacts = new ToGetContacts();
        toGetContacts.setPhone(claves.getPhone());
        toGetContacts.setKey(claves.getKey());
        toGetContacts.setContacts(contacts);

        Log.d(TAG + " MATCHES","Objeto a mandar: "+ toGetContacts.toString());

        Call<Matches> call = servicioRest.getMatches(toGetContacts);

        call.enqueue(new Callback<Matches>() {
            @Override
            public void onResponse(Call<Matches> call, Response<Matches> response) {
                Log.d(TAG + " MATCHES","Se ha obtenido el siguiente objeto: " +  response.body().toString());
                //Aquí guardaremos los matches recibidos en el objeto claves
                Matches matches = (Matches) response.body();

                //En el "main" comprobaremos el código
                claves.setErrorCode(matches.getError_code());
                if (matches.getError_code() == 0){
                    //si se ha realizado la operación con éxito, se guardarán los matches
                    //En este caso el objeto "Claves" estará referenciado aquí y donde lanzamos la petición
                    claves.setMatches(matches.getMatches()); // guardamos en el objeto CLAVES los valores recibidos
                }

                //------------------------MODIFICAMOS CÓDIGO A ENVIAR-------------------------------
                codMatches = matches.getError_code();


            }

            @Override
            public void onFailure(Call<Matches> call, Throwable t) {

                Log.d(TAG + " MATCHES","Somthing happened: " + t.getMessage());
            }
        });

        return codMatches;
    }


    public int enviarCoordenadas (double lat, double lon){

        Log.d(TAG + " S.COORD","Vamos a mandar coordenadas Lat: " + lat + " Lon: " + lon);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Creamos objeto a mandar
        ToSendCoord toSendCoord = new ToSendCoord();
        toSendCoord.setPhone(claves.getPhone());
        toSendCoord.setKey(claves.getKey());
        toSendCoord.setLat(lat);
        toSendCoord.setLon(lon);

        Log.d(TAG + " S.COORD","Mandando petición con: "+ toSendCoord.toString());

        ServicioRest servicioRest = retrofit.create(ServicioRest.class);

        Call <SendCoord> call = servicioRest.sendCoord(toSendCoord);

        call.enqueue(new Callback<SendCoord>() {
            @Override
            public void onResponse(Call<SendCoord> call, Response<SendCoord> response) {
                //AQUÍ NO TENEMOS QUE HACER NADA MÁS.... ????
                SendCoord sendCoord = (SendCoord) response.body();
                codSendCoord = sendCoord.getErrorCode();
//-----------------------  ALGUNA COMPROBACIÓN  ------------------------- ????
                Log.d(TAG + " S.COORD","Respuesta petición: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<SendCoord> call, Throwable t) {

                Log.d(TAG + " S.COORD","Something happened: " + t.getMessage());
            }
        });

        return codSendCoord;
    }


    //último método para poder representar las coordenadas

//----------------- SI TODO FUNCIONA COMO LO PREVISTO, LOS MATCHES SE GENERARÁN AL INICIAR LA APP ----------
    // -------- POR TANTO NO NECESITAMOS MANDAR NADA PARA OBTENERLOS

    // ---- EN CASO DE QUE ALGO HAYA IDO MAL, SE ACCEDERÁN A LOS DATOS ALMACENADOS EN LA BBDD -----------

    //en caso de que la conexión haya ido mal, devolverá null.
    public ArrayList<UsuariosRest> obtenerCoordenadas(){

        Log.d(TAG + " G.COORD","Mandando petición de coordenadas de los usuarios");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //OBJETO A MANDAR
        //debe ser independiente al generado "patrón singleton" para que se pueda serializar
        ToGetCoord toGetCoord = new ToGetCoord();
        toGetCoord.setPhone(claves.getPhone());
        toGetCoord.setKey(claves.getKey());
        toGetCoord.setMatches(claves.getMatches());

        Log.d(TAG + " G.COORD","Mandando petición con: " + toGetCoord.toString());

        ServicioRest servicioRest = retrofit.create(ServicioRest.class);

        Call <GetCoord> call = servicioRest.getCoord(toGetCoord);


        call.enqueue(new Callback<GetCoord>() {
            @Override
            public void onResponse(Call<GetCoord> call, Response<GetCoord> response) {
                //en caso de haber realizado la petición con éxito enviaremos el array de usuarios
                GetCoord getCoord = (GetCoord) response.body();

                //como es una fase de pruebas, vamos a comprobar los datos recibidos
                Log.d(TAG + " G.COORD","Recibida respuesta: " + response.body().toString());
                if (getCoord.getErrorCode() == 0){
                    arrayList = getCoord.getCoordinates();

                }

            }

            @Override
            public void onFailure(Call<GetCoord> call, Throwable t) {

                Log.d(TAG + " G.COORD","Something happened: " + t.getMessage());
            }
        });

        return arrayList;
    }

}
