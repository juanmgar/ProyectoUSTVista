package com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend;



import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Usuario on 24/11/2016.
 */


public class ToRegister {

    @SerializedName("phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
