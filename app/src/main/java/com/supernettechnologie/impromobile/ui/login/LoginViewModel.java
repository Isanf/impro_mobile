package com.supernettechnologie.impromobile.ui.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Retrofit;

import com.supernettechnologie.impromobile.data.model.ResponseAuthentication;
import com.supernettechnologie.impromobile.data.LoginRepository;
import com.supernettechnologie.impromobile.R;
import com.supernettechnologie.impromobile.data.Result;
import com.supernettechnologie.impromobile.webapi.ApiServers;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;


    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public Result<ResponseAuthentication> login(Context context, String username, String password) {
        // can be launched in a separate asynchronous job
        Result<ResponseAuthentication> result = loginRepository.login(context, username, password);

        if (result instanceof Result.Success) {
            loginResult.setValue(new LoginResult(R.string.login_succes));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
        return result;
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 3;
    }
}
