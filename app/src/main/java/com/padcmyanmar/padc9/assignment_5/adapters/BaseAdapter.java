package com.padcmyanmar.padc9.assignment_5.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.padc9.assignment_5.views.holders.BaseViewHolder;

import java.util.List;

public abstract class BaseAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    /*private List<W> mData;

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData = data;
        notifyDataSetChanged();
    }*/
}
