package com.example.net.activity;

import android.app.Application;

import com.example.net.tokhttputils.TOkHttpUtils;
import com.example.net.tokhttputils.TPublicParam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by lpc on 2016/11/7.
 * 记得在Manifest里的Application里添加name字段，指定为TApplication
 * android:name="com.example.net.activity.TApplication"
 */

public class TApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        /**
         * 初始化OkHttpClient
         */
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10*1000L, TimeUnit.MILLISECONDS)
                .readTimeout(10*1000L, TimeUnit.MILLISECONDS)
                .build();
        TOkHttpUtils.initClient(client) ;
        /**
         * 初始化请求体里的公参，即pub_args里的东西
         */
        Map<String,Object> publicparam = new HashMap<>() ;
        TOkHttpUtils.initPubParams(TPublicParam.addPublicParams(publicparam));
        /**
         * 初始化请求头里的s字段
         */
        TOkHttpUtils.initHeadS("userModule");

    }
}
