package com.gjj.gd.mvpdemo.googlemvp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gjj.gd.mvpdemo.R;
import com.gjj.gd.mvpdemo.googlemvp.contract.UserInfoContract;
import com.gjj.gd.mvpdemo.googlemvp.model.UserInfoModel;
import com.gjj.gd.mvpdemo.googlemvp.presenter.UserInfoPresenter;

public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.View {

    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_address;
    private UserInfoContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        tv_name = ((TextView) findViewById(R.id.tv_name));
        tv_age = ((TextView) findViewById(R.id.tv_age));
        tv_address = ((TextView) findViewById(R.id.tv_address));
        new UserInfoPresenter(this);
        mPresenter.start();
    }

    @Override
    public void setPresenter(UserInfoContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在加载。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel != null) {
            tv_address.setText(userInfoModel.getAddress());
            tv_age.setText(String.valueOf(userInfoModel.getAge()));
            tv_name.setText(userInfoModel.getName());
        }
    }

    @Override
    public String loadUserId() {
        return "1000";//假设需要查询的用户信息的userId是1000
    }
}
