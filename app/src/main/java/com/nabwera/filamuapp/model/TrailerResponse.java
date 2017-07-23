package com.nabwera.filamuapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nabwera on 22/07/2017.
 */

public class TrailerResponse {

    @SerializedName("id")
    private int id_trailer;
    @SerializedName("results")
    private List<Trailer> results;

    public int getIdTrailer(){
        return id_trailer;
    }

    public void setIdTrailer(int id_trailer){
        this.id_trailer = id_trailer;
    }

    public List<Trailer> getResults(){
        return results;
    }
}
