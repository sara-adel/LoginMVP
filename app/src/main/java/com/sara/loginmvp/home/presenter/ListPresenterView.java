package com.sara.loginmvp.home.presenter;

import com.sara.loginmvp.home.model.Data;
import com.sara.loginmvp.home.view.HomeView;

import java.util.ArrayList;

/**
 * Created by sara on 3/19/2018.
 */

public class ListPresenterView implements ListPresenter{

    HomeView homeView;

    private String[] names = {"Sara", "Sara", "Sara", "Sara", "Sara", "Sara", "Sara"};
    private String[] job = {"Android Developer", "Android Developer", "Android Developer", "Android Developer",
            "Android Developer", "Android Developer", "Android Developer"};

    public ListPresenterView(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public ArrayList<Data> loadData() {

        ArrayList<Data> rowItem = new ArrayList<>();
        for (int i = 0 ; i < names.length ; i++){
            Data itemModel = new Data();
            itemModel.setName(names[i]);
            itemModel.setJob(job[i]);
            rowItem.add(itemModel);
        }
        return rowItem;
    }
}
