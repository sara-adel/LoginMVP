package com.sara.loginmvp.home.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sara.loginmvp.R;
import com.sara.loginmvp.home.adapter.RecyclerAdapter;
import com.sara.loginmvp.home.model.Data;
import com.sara.loginmvp.home.presenter.ListPresenterView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements HomeView{

    private TextView nameText;
    String nameValue, passValue;
    private RecyclerView dataList;
    LinearLayoutManager layoutManager;
    RecyclerAdapter listAdapter;
    ArrayList<Data> data;

    ListPresenterView listPresenterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    public void init(){
        nameText = findViewById(R.id.nameText);
        dataList = findViewById(R.id.list);

        listPresenterView = new ListPresenterView(this);
        data = onLoadData();
        listAdapter = new RecyclerAdapter(data, this);

        layoutManager = new LinearLayoutManager(this);
        dataList.setLayoutManager(layoutManager);
        dataList.setAdapter(listAdapter);

        Bundle retriveData = getIntent().getExtras();
        if (retriveData != null) {
            nameValue = retriveData.getString("name");
            passValue = retriveData.getString("pass");
        }

        nameText.setText(nameValue + " , " + passValue);

    }

    @Override
    public ArrayList<Data> onLoadData() {
        data = listPresenterView.loadData();
        return data;
    }
}