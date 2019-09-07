package com.padcmyanmar.padc9.assignment_5.delegates;

import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public interface ItemClicked {

    void onGetAllHotels(EventModel.GetEventsFromNetworkDelegate delegate);
    void onClickedItem(int hotelId);
    void onLayoutChange(LayoutManagerDelegate layoutManagerDelegate);
    void searchByName(SearchDelegate searchDelegate);

    public interface LayoutManagerDelegate {
        void onChangeToLinearLayout();
        void onChangeToGridLayout();
    }

    public interface SearchDelegate{
        void searchSuccess(List<HotelVO> hotelVOS);
    }
}
