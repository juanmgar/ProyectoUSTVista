package com.example.olaznog59.proyectoustvista.ServicioRest.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Generated;

/**
 * Created by Usuario on 23/11/2016.
 */

@Generated("org.jsonschema2pojo")

public class GetCoord {

    @SerializedName("coordinates")
    @Expose
    private ArrayList<String> coordinates;
    @SerializedName("error_description")
    @Expose
    private String error_description;
    @SerializedName("error_code")
    @Expose
    private int error_code;

    public ArrayList<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
