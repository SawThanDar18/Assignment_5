package com.padcmyanmar.padc9.assignment_5.data.models;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel{

    private Map<Integer, HotelVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    private EventModelImpl(){
        eventsDataRepository = new HashMap<>();
    }

    public static EventModelImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new EventModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(final GetEventsFromNetworkDelegate delegate) {
        mDataAgent.getEvents(new EventsDataAgent.GetEventsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HotelVO> events) {
                for (HotelVO hotelVO : events){
                    eventsDataRepository.put(hotelVO.getId(), hotelVO);
                }
                delegate.onSuccess(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        });
    }

    @Override
    public HotelVO findEventById(int hotelId) {
        HotelVO hotelVO = eventsDataRepository.get(hotelId);
        return hotelVO;
    }
}
