package com.padcmyanmar.padc9.assignment_5.data.models;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public interface EventModel {

    void getEvents(GetEventsFromNetworkDelegate delegate);
    HotelVO findEventById(int hotelId);
    List<HotelVO> searchByName(String name);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<HotelVO> events);
        void onFailure(String errorMessage);
    }
}
