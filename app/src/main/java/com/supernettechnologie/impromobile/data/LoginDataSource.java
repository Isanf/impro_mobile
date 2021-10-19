package com.supernettechnologie.impromobile.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.supernettechnologie.impromobile.data.model.AuthCredentials;
import com.supernettechnologie.impromobile.data.model.ResponseAuthentication;
import com.supernettechnologie.impromobile.data.model.LoggedInUser;
import com.supernettechnologie.impromobile.ui.login.LoginActivity;
import com.supernettechnologie.impromobile.webapi.ApiServers;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    LoggedInUser user;
    String tokenId;
    private static final String BASE_URL = "http://172.16.250.12:8080";
    private Retrofit retrofit;
    private ApiServers servers;


    public Result<ResponseAuthentication> login(Context applicationContext, String username, String password) {

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servers = retrofit.create(ApiServers.class);

        AuthCredentials credentials = new AuthCredentials();
        credentials.username = username;
        credentials.password = password;

        Call<ResponseAuthentication> call = servers.authenticate(credentials);
        try {
            call.enqueue(new Callback<ResponseAuthentication>() {
                @Override
                public void onResponse(Call<ResponseAuthentication> call, Response<ResponseAuthentication> response) {
                    SharedPreferences.Editor editor = prefs.edit();
                    tokenId = response.body().getId_token();
                    editor.putString("token", tokenId);
                    editor.apply();
                    System.out.println(response.body().getId_token());
                }

                @Override
                public void onFailure(Call<ResponseAuthentication> call, Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
            return new Result.Success<>(tokenId);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
