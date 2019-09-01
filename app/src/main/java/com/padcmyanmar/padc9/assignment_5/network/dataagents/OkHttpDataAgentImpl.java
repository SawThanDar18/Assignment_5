package com.padcmyanmar.padc9.assignment_5.network.dataagents;

import android.os.AsyncTask;
import android.support.v4.widget.NestedScrollView;

import com.padcmyanmar.padc9.assignment_5.network.responses.GetEventsResponse;

public class OkHttpDataAgentImpl implements EventsDataAgent {

    private static OkHttpDataAgentImpl objInstance;

    public OkHttpDataAgentImpl() {
    }

    public static OkHttpDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private GetEventsFromNetworkDelegate delegate;

        public GetEventsTask(GetEventsFromNetworkDelegate delegate) {
            this.delegate = delegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {
            return null;
        }
    }
}
