package com.padcmyanmar.padc9.assignment_5.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;
import com.padcmyanmar.padc9.assignment_5.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.assignment_5.utils.EventsConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel{

    private Map<Integer, HotelVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    private EventModelImpl(Context context){
        super(context);
        eventsDataRepository = new HashMap<>();
    }

    public static void initializeEventModel(Context context){
        objInstance = new EventModelImpl(context);
    }

    public static EventModelImpl getObjInstance(){
        if(objInstance == null){
            throw new RuntimeException(EventsConstants.EM_EVENT_MODEL_NOT_INITIALIZED);
        }
        return objInstance;
    }

    @Override
    public void getEvents(final GetEventsFromNetworkDelegate delegate) {

        if (mDatabase.areDatasExistInDB()) {
            List<HotelVO> dataFromDB = mDatabase.hotelDao().getAll();
            delegate.onSuccess(dataFromDB);
        } else {
            mDataAgent.getEvents(new EventsDataAgent.GetEventsFromNetworkDelegate() {
                @Override
                public void onSuccess(List<HotelVO> events) {
                /*for (HotelVO hotelVO : events){
                    eventsDataRepository.put(hotelVO.getId(), hotelVO);
                }*/
                long[] ids = mDatabase.hotelDao().insertHotels(events);
                delegate.onSuccess(events);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public HotelVO findEventById(int hotelId) {
        HotelVO hotelVO = eventsDataRepository.get(hotelId);
        return hotelVO;
    }

    @Override
    public List<HotelVO> searchByName(String name) {

        List<HotelVO> searchNames = new ArrayList<>();

        for (HotelVO hotelVOList : searchNames) {
            if (hotelVOList.getName().toLowerCase().contains(name.toLowerCase())) {
                searchNames.add(hotelVOList);
            }
        }
        return searchNames;
    }
}
