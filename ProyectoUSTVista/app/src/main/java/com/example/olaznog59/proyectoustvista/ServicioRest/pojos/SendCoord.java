package com.example.olaznog59.proyectoustvista.ServicioRest.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Usuario on 23/11/2016.
 */

@Generated("org.jsonschema2pojo")

public class SendCoord {

    @SerializedName("error_description")
    @Expose
    private String error_description;
    @SerializedName("error_code")
    @Expose
    private int error_code;
}
