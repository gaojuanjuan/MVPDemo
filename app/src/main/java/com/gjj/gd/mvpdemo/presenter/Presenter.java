package com.gjj.gd.mvpdemo.presenter;

/**
 * author: GD on 2016/10/19 14:05
 * email :2301722691@qq.com
 */

public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
