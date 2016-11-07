package com.example.net.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.net.tokhttputils.TBaseApi;
import com.example.net.tokhttputils.TBaseCallback;
import com.example.net.tokhttputils.TOkHttpResponse;
import com.example.net.tokhttputils.R;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String,String> headers = new HashMap<>();
        headers.put("module","user");
        headers.put("action","getUserInfo");
        Map<String,Object> pri_args = new HashMap<>() ;
        pri_args.put("username","宇智波佐助");

        TBaseApi.createPostRequest("getUserInfo",pri_args,new TBaseCallback<TBaseDataResult<TLogin>>(){

            @Override
            public void onResponse(TOkHttpResponse<TBaseDataResult<TLogin>> response, int i) {
                if (response.getStatus() == 200) {
                    TLogin data = response.getResult().getData();
                    int uid = data.getUid() ;
                    String username = data.getUsername() ;
                    String token = data.getToken() ;
                }
            }
        });
    }
}
