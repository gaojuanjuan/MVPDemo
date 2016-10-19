package com.gjj.gd.mvpdemo.presenter;

import com.gjj.gd.mvpdemo.model.MainModelBean;

/**
 * author: GD on 2016/10/19 14:04
 * email :2301722691@qq.com
 * 此接口作用是连接model
 */

public interface IMainPresenter {
    void loadDataSuccess(MainModelBean mainModelBean);
    void loadDataFailure();
}
