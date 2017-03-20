package com.gjj.gd.mvpdemo.googlemvp.presenter;

import android.os.Handler;

import com.gjj.gd.mvpdemo.googlemvp.contract.UserInfoContract;
import com.gjj.gd.mvpdemo.googlemvp.model.UserInfoModel;
import com.gjj.gd.mvpdemo.presenter.Presenter;

/**
 * Created by 高娟娟 on 2017/3/20.
 */

public class UserInfoPresenter  implements UserInfoContract.Presenter{
    private UserInfoContract.View mView;

    public UserInfoPresenter(UserInfoContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }


    @Override
    public void loadUserInfo() {
        String userId = mView.loadUserId();
        mView.showLoading();//接口请求前显示loading
        //模拟接口请求回调
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json，并转换为javabean
                UserInfoModel userInfoModel = new UserInfoModel("马云", 50, "杭州");
                mView.showUserInfo(userInfoModel);
                mView.dismissLoading();
            }
        },3000);
    }

    @Override
    public void start() {
        loadUserInfo();
    }

}
