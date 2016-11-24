package com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.annotation.Generated;

/**
 * Created by Usuario on 24/11/2016.
 */

@Generated("org.jsonschema2pojo")

public class ToGetCoord {
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("matches")
    @Expose
    private ArrayList<String> matches;

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

    public ArrayList<String> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<String> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return "{" +
                "phone='" + phone + '\'' +
                ", key='" + key + '\'' +
                ", matches=" + matches +
                '}';
    }
}
