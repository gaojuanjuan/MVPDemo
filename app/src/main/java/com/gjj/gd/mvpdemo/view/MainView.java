package com.gjj.gd.mvpdemo.view;

import com.gjj.gd.mvpdemo.model.MainModelBean;

/**
 * author: GD on 2016/10/19 14:05
 * email :2301722691@qq.com
 * 处理业务逻辑需要的方法
 */

public interface MainView {
    void showData(MainModelBean mainModelBean);
    void showProgress();
    void hideProgress();
}
