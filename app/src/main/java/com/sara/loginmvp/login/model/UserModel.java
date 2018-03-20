package com.sara.loginmvp.login.model;

/**
 * Created by sara on 3/19/2018.
 */

public class UserModel implements User {

    String name, pass;

    public UserModel(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public int checkUserValidity(String name, String pass) {
        if (name == null || pass == null ){
            return -1;
        }
        return 0;
    }
}
