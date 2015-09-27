package com.boredump.sciencehook.base;

import android.app.Application;

import com.boredump.sciencehook.SplashActivity;
import com.parse.Parse;
import com.parse.ParseUser;

/**
 * Created by maagarwa on 9/27/2015.
 */
public class MyApplication extends Application {
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String PARSE_APPLICATION_ID = "UTkjfNQdX6SiobHLRxMADQjQfX32qCy6f29i1xlS";
    private static final String PARSE_CLIENT_KEY = "YiYhqlkDZuWHeqVXI9c9iz0fjbgAbOjlJaUXzFUf";

    private static MyApplication singleton;
    ParseUser currentUser;

    public MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);

        currentUser = ParseUser.getCurrentUser();
    }
}
