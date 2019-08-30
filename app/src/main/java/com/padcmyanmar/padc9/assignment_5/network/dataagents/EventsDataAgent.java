package com.padcmyanmar.padc9.assignment_5.network.dataagents;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public interface EventsDataAgent {

    void getEvents(GetEventsFromNetworkDelegate delegate);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<HotelVO> events);
        void onFailure(String errorMessage);
    }
}
