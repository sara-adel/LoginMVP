package com.sara.loginmvp.login.view;

/**
 * Created by sara on 3/19/2018.
 */

public interface LoginView {

    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetVisibility(int visibility);
}
