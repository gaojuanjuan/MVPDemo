package com.gjj.gd.mvpdemo.login.presenter;

import com.gjj.gd.mvpdemo.login.model.User;
import com.gjj.gd.mvpdemo.login.view.ILoginView;

/**
 * Created by 高娟娟 on 2017/3/27.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    private  ILoginView loginView;
    private  User user;

    public LoginPresenterCompl(ILoginView view) {
        loginView = view;
        user  = new User("张三","123456");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean result = false;
        int code = 0;
        if (name.equals(user.getName())&& password.equals(user.getPassword())){
            result = true;
            code = 1;
        }else {
            result = false;
            code = 0;
        }
        loginView.onLoginResult(result,code);
    }
}
