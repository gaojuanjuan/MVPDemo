package com.gjj.gd.mvpdemo.googlemvp.contract;

import com.gjj.gd.mvpdemo.googlemvp.model.UserInfoModel;
import com.gjj.gd.mvpdemo.googlemvp.presenter.BasePresenter;


/**
 * Created by 高娟娟 on 2017/3/20.
 */

public interface UserInfoContract {
    interface View extends BaseView<Presenter> {
        void showLoading();//展示加载框
        void dismissLoading();//取消加载框展示
        void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调
        String loadUserId();////假设接口请求需要一个userId
    }

    interface Presenter extends BasePresenter {
        void loadUserInfo();
    }
}
