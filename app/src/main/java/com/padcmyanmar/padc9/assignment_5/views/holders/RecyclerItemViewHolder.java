package com.padcmyanmar.padc9.assignment_5.views.holders;

import android.support.annotation.NonNull;
import android.view.View;

import com.padcmyanmar.padc9.assignment_5.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

public class RecyclerItemViewHolder extends BaseViewHolder<HotelVO> {

    private ItemClicked itemClicked;

    public RecyclerItemViewHolder(@NonNull View itemView, ItemClicked delegate) {
        super(itemView);

        itemClicked = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClicked.onClicked();
            }
        });
    }

    @Override
    public void bindData(HotelVO data) {

    }
}
