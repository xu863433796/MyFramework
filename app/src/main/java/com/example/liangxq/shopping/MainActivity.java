package com.example.liangxq.shopping;

import android.os.Bundle;
import android.util.Log;

import com.example.httplibrary.HttpManager;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.server.ApiServer;
import com.example.httplibrary.utils.JsonUtils;
import com.example.httplibrary.utils.LogUtils;
import com.example.liangxq.shopping.httpdemo.shopping.ShopDemo;
import com.example.liangxq.shopping.httpdemo.wanandroid.Demo;
import com.example.liangxq.shopping.httpdemo.wanandroid.HttpCallBack;
import com.example.liangxq.shopping.mvp.model.MyPresenter;
import com.example.liangxq.shopping.mvp.model.MyView;
import com.example.mvplibrary.base.BaseMvpActivity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MainActivity extends BaseMvpActivity<MyView,MyPresenter> implements MyView{


    @Override
    public void showDemo(Demo demo) {
        Log.e("111",demo.toString());
    }

    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
            mPresenter.getData();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }
}
