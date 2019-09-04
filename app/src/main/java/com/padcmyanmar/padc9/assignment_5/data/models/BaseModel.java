package com.padcmyanmar.padc9.assignment_5.data.models;

import com.padcmyanmar.padc9.assignment_5.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.OkHttpDataAgentImpl;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.RetrofitDataAgentImpl;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;

    BaseModel(){
        //this.mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        //mDataAgent = OkHttpDataAgentImpl.getObjInstance();
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();
    }
}
