package com.padcmyanmar.padc9.assignment_5.data.models;

import com.padcmyanmar.padc9.assignment_5.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.HttpUrlConnectionDataAgentImpl;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;

    BaseModel(){
        mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
    }
}
