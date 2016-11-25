package com.example.olaznog59.proyectoustvista.ServicioRest.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Usuario on 25/11/2016.
 */

public class UsuariosRest {
    @SerializedName("phone")
    private String phone;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "UsuariosRest{" +
                "phone='" + phone + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
