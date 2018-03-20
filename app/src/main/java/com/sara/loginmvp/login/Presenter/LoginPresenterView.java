package com.sara.loginmvp.login.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.sara.loginmvp.login.model.User;
import com.sara.loginmvp.login.model.UserModel;
import com.sara.loginmvp.login.view.LoginView;


/**
 * Created by sara on 3/19/2018.
 */

public class LoginPresenterView implements LoginPresenter {

    LoginView loginView;
    User user;
    Handler handler;

    public LoginPresenterView(LoginView loginView) {
        this.loginView = loginView;
        init();
        handler = new Handler(Looper.getMainLooper()) ;
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String pass) {
        Boolean isSuccess = true;
        final int code = user.checkUserValidity(name, pass);
        if (code != 0) isSuccess = false;

        final Boolean result = isSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    loginView.onLoginResult(result, code);
            }
        }, 500);
    }

    @Override
    public void setVisiblity(int visiblity) {
        loginView.onSetVisibility(visiblity);
    }

    private void init(){
        user = new UserModel("mvp", "mvp");
    }
}