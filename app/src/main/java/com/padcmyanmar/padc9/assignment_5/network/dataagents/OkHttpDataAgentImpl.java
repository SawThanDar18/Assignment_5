package com.padcmyanmar.padc9.assignment_5.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.assignment_5.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements EventsDataAgent {

    private static OkHttpDataAgentImpl objInstance;

    private OkHttpClient okHttpClient;

    public OkHttpDataAgentImpl() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(okHttpClient, delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private OkHttpClient okHttpClient;
        private GetEventsFromNetworkDelegate delegate;

        public GetEventsTask(OkHttpClient okHttpClient, GetEventsFromNetworkDelegate delegate) {
            this.okHttpClient = okHttpClient;
            this.delegate = delegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            RequestBody formBody = new FormBody.Builder()
                    .build();

            Request request = new Request.Builder()
                    .url(EventsConstants.BASE_URL + EventsConstants.GET_EVENTS)
                    .post(formBody)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseString = response.body().string();

                    GetEventsResponse getEventsResponse = new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if (eventsResponse != null){
                if (eventsResponse.isResponseOk()){
                    delegate.onSuccess(eventsResponse.getHotelVOList());
                }else {
                    delegate.onFailure(eventsResponse.getMessage());
                }
            }else {
                delegate.onFailure(EventsConstants.EM_NULL_EVENT_RESPONSE);
            }
        }
    }
}
