package com.padcmyanmar.padc9.assignment_5.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.padcmyanmar.padc9.assignment_5.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.activities.DetailsActivity;
import com.padcmyanmar.padc9.assignment_5.adapters.RecyclerItemAdapter;
import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;
import com.padcmyanmar.padc9.assignment_5.data.models.EventModelImpl;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import java.util.List;

public class TopCollectionFragment extends Fragment implements ItemClicked {


    public TopCollectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_top_collection, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false));

        final RecyclerItemAdapter recyclerItemAdapter = new RecyclerItemAdapter(this);
        recyclerView.setAdapter(recyclerItemAdapter);

        EventModelImpl.getObjInstance().getEvents(new EventModel.GetEventsFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HotelVO> events) {
                Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClicked() {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        startActivity(intent);
    }
}
