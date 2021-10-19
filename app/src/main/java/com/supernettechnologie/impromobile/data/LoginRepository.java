package com.supernettechnologie.impromobile.data;

import android.content.Context;

import com.supernettechnologie.impromobile.data.model.ResponseAuthentication;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private ResponseAuthentication user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(ResponseAuthentication user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<ResponseAuthentication> login(Context context, String username, String password) {
        // handle login
        Result<ResponseAuthentication> result = dataSource.login(context, username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<ResponseAuthentication>) result).getData());
        }
        return result;
    }
}
