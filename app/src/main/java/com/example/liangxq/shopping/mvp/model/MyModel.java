package com.example.liangxq.shopping.mvp.model;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.httplibrary.utils.LogUtils;
import com.example.liangxq.shopping.httpdemo.wanandroid.Demo;
import com.example.liangxq.shopping.httpdemo.wanandroid.HttpCallBack;
import com.example.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;

import javax.security.auth.callback.Callback;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.mvp.model
 * 文件名：MyModel
 * 创建者：liangxq
 * 创建时间：2020/8/5  16:12
 * 描述：TODO
 */
public class MyModel implements BaseModel {
    interface CallBack1{
        void showDemo(Demo demo);
    }
    public void getData(final CallBack1 callback){
        new HttpClient.Builder()
                .setApiUrl("wxarticle/list/408/1/json")
                .get()
                .build().request(new HttpCallBack<Demo>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message);
            }
            @Override
            public void cancle() {

            }
            @Override
            public void onSuccess(Demo demo) {
                LogUtils.e(demo.toString());
                callback.showDemo(demo);
            }

            @Override
            public Demo convert(JsonElement result) {
                return JsonUtils.jsonToClass(result,Demo.class);
            }
        });
    }
}
