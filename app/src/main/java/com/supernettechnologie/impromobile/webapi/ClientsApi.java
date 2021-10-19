package com.supernettechnologie.impromobile.webapi;

import com.supernettechnologie.impromobile.data.model.Vente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientsApi {
    private static final String BASE_URL = "http://172.16.250.12:8080";
    private Retrofit retrofit;
    private ApiServers servers;
    private static ClientsApi INSTANCE;

    public ClientsApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servers = retrofit.create(ApiServers.class);
    }
    public static ClientsApi getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new ClientsApi();
        }
        return INSTANCE;
    }

    public Call<List<Vente>> getVentes(String authorization){
        return servers.getAllVente(authorization);
    }
}
