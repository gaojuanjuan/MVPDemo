package com.gjj.gd.mvpdemo.presenter;

import com.gjj.gd.mvpdemo.model.MainModel;
import com.gjj.gd.mvpdemo.model.MainModelBean;
import com.gjj.gd.mvpdemo.view.MainView;

/**
 * author: GD on 2016/10/19 14:05
 * email :2301722691@qq.com
 * view和model的桥梁，他从model层检索数据后，返回给view层
 */

public class MainPresenter implements Presenter<MainView>,IMainPresenter {

    private MainView mMainView;
    private MainModel mMainModel;

    public MainPresenter(MainView mainView) {
        attachView(mainView);
        mMainModel = new MainModel(this);
    }

    public void loadData(){
        mMainView.showProgress();
        mMainModel.loadData();
    }

    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {
        mMainView.showData(mainModelBean);
        mMainView.hideProgress();
    }

    @Override
    public void loadDataFailure() {
        mMainView.hideProgress();
    }

    @Override
    public void attachView(MainView view) {
        this.mMainView = view;
    }

    @Override
    public void detachView() {
        this.mMainView = null;
    }
}
