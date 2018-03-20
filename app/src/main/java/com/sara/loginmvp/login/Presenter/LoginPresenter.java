package com.sara.loginmvp.login.Presenter;

/**
 * Created by sara on 3/19/2018.
 */

public interface LoginPresenter {

    void clear();
    void doLogin(String name, String pass);
    void setVisiblity(int visiblity);
}