package com.gjj.gd.mvpdemo.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gjj.gd.mvpdemo.R;
import com.gjj.gd.mvpdemo.model.MainModelBean;
import com.gjj.gd.mvpdemo.presenter.MainPresenter;
import com.gjj.gd.mvpdemo.view.MainView;

/**
 * 由Activity/Fragment实习View里方法，包含一个Presenter的应用
 */
public class MainActivity extends AppCompatActivity implements MainView{

    private TextView text;
    private ProgressBar mProgressBar;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mMainPresenter = new MainPresenter(this);
        //制造延迟效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMainPresenter.loadData();
            }
        },2000);
    }

    @Override
    public void showData(MainModelBean mainModelBean) {
        String showData = getResources().getString(R.string.city) + mainModelBean.getCity()+'\n'
                + getResources().getString(R.string.wd) + mainModelBean.getWd()+"\n"
                + getResources().getString(R.string.ws) + mainModelBean.getWs()+"\n"
                + getResources().getString(R.string.time) + mainModelBean.getTime();
        text.setText(showData);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();
        super.onDestroy();
    }
}
