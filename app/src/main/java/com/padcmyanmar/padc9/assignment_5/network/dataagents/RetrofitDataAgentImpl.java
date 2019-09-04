package com.padcmyanmar.padc9.assignment_5.network.dataagents;

import com.padcmyanmar.padc9.assignment_5.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.assignment_5.network.responses.HotelApi;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements EventsDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private OkHttpClient okHttpClient;

    private Retrofit retrofit;

    private HotelApi hotelApi;

    public RetrofitDataAgentImpl(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(EventsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        hotelApi = retrofit.create(HotelApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(final GetEventsFromNetworkDelegate delegate) {
        Call<GetEventsResponse> eventsResponseCall = hotelApi.getAllEvents();
        eventsResponseCall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                GetEventsResponse getEventsResponse = response.body();
                delegate.onSuccess(getEventsResponse.getHotelVOList());
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }

}
