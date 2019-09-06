package com.padcmyanmar.padc9.assignment_5.delegates;

import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;

public interface ItemClicked {

    void onGetAllHotels(EventModel.GetEventsFromNetworkDelegate delegate);
    void onClickedItem(int hotelId);
    void onLayoutChange(LayoutManagerDelegate layoutManagerDelegate);

    public interface LayoutManagerDelegate {
        void onChangeToLinearLayout();
        void onChangeToGridLayout();
    }
}
