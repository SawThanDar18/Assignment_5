package com.padcmyanmar.padc9.assignment_5.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc9.assignment_5.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;
import com.padcmyanmar.padc9.assignment_5.views.holders.RecyclerItemViewHolder;

public class RecyclerItemAdapter extends BaseAdapter<RecyclerItemViewHolder, HotelVO> {

    private ItemClicked itemClicked;

    public RecyclerItemAdapter(ItemClicked itemClicked) {
        this.itemClicked = itemClicked;
    }

    @NonNull
    @Override
    public RecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_itemview, viewGroup, false);
        return new RecyclerItemViewHolder(view, itemClicked);
    }

}
