package com.padcmyanmar.padc9.assignment_5;

import android.app.Application;

import com.padcmyanmar.padc9.assignment_5.data.models.EventModelImpl;

public class HotelApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventModelImpl.initializeEventModel(getApplicationContext());
    }
}
