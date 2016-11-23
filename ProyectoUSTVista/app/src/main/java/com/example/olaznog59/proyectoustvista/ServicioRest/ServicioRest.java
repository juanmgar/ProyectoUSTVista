package com.example.olaznog59.proyectoustvista.ServicioRest;



import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.GetCoord;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Matches;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Register;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.SendCoord;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Usuario on 23/11/2016.
 */

//-----------------------------------------------------------------------------------------------
    //PREGUNTAR A RICARD POR LO QUE NOS DEVUELVE EL CONTENT PROVIDER, ARRAY // ARRAYLIST??

public interface ServicioRest {

    //PARA OBTENER EL ID DEL USUARIO
    @POST("/register")
    Call<Register> getId(@Field("phone") String phone);

    //PARA OBTENER LOS IDS DE NUESTRA AGENDA
    @POST("/get_contacts")
    Call<Matches> getMatches(@Field("phone") String phone, @Field("key") String id, @Field("contacts") Arrays contacts);

    //PARA MANDAR NUESTRA UBICACIÓN
    @POST("/send_coordinates")
    Call<SendCoord> sendCoord(@Field("phone") String phone, @Field("key") String id, @Field("lat") double lat, @Field("lon") double lon);

    //PARA OBTENER COORDENADAS DE TODOS LOS USUARIOS DE MI AGENDA
    @POST("/get_coordinates")
    Call<GetCoord> getCoord(@Field("phone") String phone, @Field("key") String id, @Field("matches") Arrays matches);


}
