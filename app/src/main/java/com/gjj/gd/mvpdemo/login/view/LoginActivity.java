package com.gjj.gd.mvpdemo.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gjj.gd.mvpdemo.R;
import com.gjj.gd.mvpdemo.login.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText mName;
    private EditText mPassword;
    private Button mClear;
    private Button mLogin;
    private LoginPresenterCompl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = ((EditText) findViewById(R.id.et_name));
        mPassword = ((EditText) findViewById(R.id.et_password));
        mClear = ((Button) findViewById(R.id.btn_clear));
        mLogin = ((Button) findViewById(R.id.btn_login));
        mClear.setOnClickListener(this);
        mLogin.setOnClickListener(this);

        loginPresenter = new LoginPresenterCompl(this);
    }

    @Override
    public void onClearText() {
        mClear.setText("");
        mLogin.setText("");
        Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLogin.setEnabled(true);
        mLogin.setEnabled(true);
        if (result){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        String name = mName.getText().toString();
        String password = mPassword.getText().toString();
        switch (v.getId()){
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
            case R.id.btn_login:
                loginPresenter.doLogin(name,password);
                break;
        }
    }
}
