package com.padcmyanmar.padc9.assignment_5.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.padcmyanmar.padc9.assignment_5.delegates.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.adapters.RecyclerItemAdapter;
import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public class Fragments extends Fragment{

    private ItemClicked itemClicked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));

        final RecyclerItemAdapter recyclerItemAdapter = new RecyclerItemAdapter(itemClicked);
        recyclerView.setAdapter(recyclerItemAdapter);

        itemClicked.onGetAllHotels(new EventModel.GetEventsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HotelVO> events) {
                recyclerItemAdapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });

        itemClicked.onLayoutChange(new ItemClicked.LayoutManagerDelegate() {
            @Override
            public void onChangeToLinearLayout() {
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayout.VERTICAL, false));
            }

            @Override
            public void onChangeToGridLayout() {
                recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
            }
        });

        itemClicked.searchByName(new ItemClicked.SearchDelegate() {
            @Override
            public void searchSuccess(List<HotelVO> hotelVOS) {
                recyclerItemAdapter.setNewData(hotelVOS);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemClicked = (ItemClicked) context;
    }
}
