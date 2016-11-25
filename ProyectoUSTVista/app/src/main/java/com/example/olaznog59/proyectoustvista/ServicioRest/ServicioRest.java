package com.example.olaznog59.proyectoustvista.ServicioRest;



import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToGetContacts;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToGetCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToRegister;
import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToSendCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.GetCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Matches;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Register;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.SendCoord;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Usuario on 23/11/2016.
 */

//-----------------------------------------------------------------------------------------------
    //PREGUNTAR A RICARD POR LO QUE NOS DEVUELVE EL CONTENT PROVIDER, ARRAY // ARRAYLIST??

public interface ServicioRest {

    //PARA AÑADIR LA EXTENSIÓN EL URL DEL OBJETO "RETROFIT" TIENE QUE ACABAR CON "/" PARA QUE SUME AL STRING CREADO
    //SI NO TIENE EL "/" SUSTITUIRÁ LA ÚLTIMA PARTE DE LA URL

    //PARA OBTENER EL ID DEL USUARIO
    @POST("register")
    Call<Register> getId(@Body ToRegister register);

    //PARA OBTENER LOS IDS DE NUESTRA AGENDA
    @POST("get_contacts")
    Call<Matches> getMatches(@Body ToGetContacts contacts);

    //PARA MANDAR NUESTRA UBICACIÓN
    @POST("send_coordinates")
    Call<SendCoord> sendCoord(@Body ToSendCoord coord);

    //PARA OBTENER COORDENADAS DE TODOS LOS USUARIOS DE MI AGENDA
    @POST("get_coordinates")
    Call<GetCoord> getCoord(@Body ToGetCoord toGetCoord);


}
