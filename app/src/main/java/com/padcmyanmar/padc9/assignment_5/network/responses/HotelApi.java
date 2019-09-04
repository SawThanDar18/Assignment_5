package com.padcmyanmar.padc9.assignment_5.network.responses;

import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import retrofit2.Call;
import retrofit2.http.POST;

public interface HotelApi {

    @POST(EventsConstants.GET_EVENTS)
    Call<GetEventsResponse> getAllEvents();
}
