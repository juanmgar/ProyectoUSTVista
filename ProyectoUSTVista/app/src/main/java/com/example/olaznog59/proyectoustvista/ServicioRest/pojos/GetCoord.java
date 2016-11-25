package com.example.olaznog59.proyectoustvista.ServicioRest.pojos;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by Usuario on 23/11/2016.
 */


public class GetCoord {

    @SerializedName("coordinates")
    private ArrayList<UsuariosRest> coordinates;
    @SerializedName("error_description")
    private String errorDescription;
    @SerializedName("error_code")
    private int errorCode;

    public ArrayList<UsuariosRest> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<UsuariosRest> coordinates) {
        this.coordinates = coordinates;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "GetCoord{" +
                "coordinates=" + coordinates +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorCode=" + errorCode +
                '}';

    }
}
