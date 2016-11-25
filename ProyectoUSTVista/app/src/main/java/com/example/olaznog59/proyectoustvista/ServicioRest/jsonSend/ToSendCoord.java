package com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Usuario on 24/11/2016.
 */

@Generated("org.jsonschema2pojo")

public class ToSendCoord {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        return "{" +
                "phone='" + phone + '\'' +
                ", key='" + key + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
