package com.example.net.activity;

/**
 * Created by lpc on 2016/11/7.
 */

public class TBaseDataResult<T> {
    int total ;
    T data ;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
