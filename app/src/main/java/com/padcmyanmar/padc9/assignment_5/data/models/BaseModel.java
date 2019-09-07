package com.padcmyanmar.padc9.assignment_5.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.assignment_5.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.OkHttpDataAgentImpl;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.RetrofitDataAgentImpl;
import com.padcmyanmar.padc9.assignment_5.persistence.HotelDatabase;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;
    protected HotelDatabase mDatabase;

    BaseModel(Context context){
        //this.mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        //mDataAgent = OkHttpDataAgentImpl.getObjInstance();
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();

        mDatabase = HotelDatabase.getObjInstance(context);
    }
}
