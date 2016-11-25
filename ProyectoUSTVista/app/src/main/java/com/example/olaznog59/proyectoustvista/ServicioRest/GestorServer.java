package com.example.olaznog59.proyectoustvista.ServicioRest;


import com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend.ToRegister;
import com.example.olaznog59.proyectoustvista.ServicioRest.pojos.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Usuario on 24/11/2016.
 */

public class GestorServer {
    String url = "[IP]:[PUERTO]/talentum_geo/rest/services";

    public String obtenerIdUsuario(String telefono){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicioRest service = retrofit.create(ServicioRest.class);

        ToRegister register = new ToRegister();
        register.setPhone(telefono);

        Call<Register> call = service.getId(register);
        call.enqueue( new Callback<Register>() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        //Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");



        return null;
    }

}
