package com.example.olaznog59.proyectoustvista.ServicioRest.jsonSend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.annotation.Generated;

/**
 * Created by Usuario on 24/11/2016.
 */

@Generated("org.jsonschema2pojo")

public class ToGetContacts {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("contacts")
    @Expose
    private ArrayList<String> contacts;

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

    public ArrayList<String> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "{" +
                "phone='" + phone + '\'' +
                ", key='" + key + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
