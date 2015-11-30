package com.ocit.trainingapi;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ar-android on 30/11/2015.
 */
public class BaseApp extends Application{

    public static BaseApp sInstance;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        requestQueue = Volley.newRequestQueue(this);
    }

    public static synchronized BaseApp getsInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}