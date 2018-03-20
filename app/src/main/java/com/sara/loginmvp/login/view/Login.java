package com.sara.loginmvp.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sara.loginmvp.home.view.Home;
import com.sara.loginmvp.login.Presenter.LoginPresenter;
import com.sara.loginmvp.login.Presenter.LoginPresenterView;
import com.sara.loginmvp.R;

public class Login extends AppCompatActivity implements LoginView{

    private EditText name, pass;
    private ProgressBar progressBar;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    public void initViews(){
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        progressBar = findViewById(R.id.progress_login);

        loginPresenter = new LoginPresenterView(this);
        loginPresenter.setVisiblity(View.INVISIBLE);
    }

    public void loginClicked(View view){
        loginPresenter.setVisiblity(View.VISIBLE);
        loginPresenter.doLogin(name.getText().toString(), pass.getText().toString());
    }

    public void clearClicked(View view){
        loginPresenter.clear();
    }

    @Override
    public void onClearText() {
        name.setText("");
        pass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setVisiblity(View.INVISIBLE);

        if (result){
            Toast.makeText(Login.this, "Login Success", Toast.LENGTH_LONG).show();
            data();
        }else {
            Toast.makeText(Login.this, "Login Fail, code = "+ code, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSetVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    public void data(){
        Bundle data = new Bundle();
        data.putString("name", name.getText().toString());
        data.putString("pass", pass.getText().toString());

        Intent intent = new Intent(Login.this , Home.class);
        intent.putExtras(data);
        startActivity(intent);
    }
}