package com.sara.loginmvp.login.model;

/**
 * Created by sara on 3/19/2018.
 */

public interface User {

    String getName();
    String getPass();
    int checkUserValidity(String name, String pass);
}
