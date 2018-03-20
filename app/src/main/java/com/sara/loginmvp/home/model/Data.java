package com.sara.loginmvp.home.model;

/**
 * Created by sara on 3/19/2018.
 */

public class Data implements IData{

    String name , job;

    public Data(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return job;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }
}