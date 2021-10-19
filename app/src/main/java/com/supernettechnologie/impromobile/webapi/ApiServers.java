package com.supernettechnologie.impromobile.webapi;



import com.supernettechnologie.impromobile.data.model.AuthCredentials;
import com.supernettechnologie.impromobile.data.model.ResponseAuthentication;
import com.supernettechnologie.impromobile.data.model.Vente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiServers {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("api/authenticate")
    Call<ResponseAuthentication> authenticate(@Body AuthCredentials credentials);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("api/allventes")
    Call<List<Vente>> getAllVente(@Header("Authorization") String authorization);
}
