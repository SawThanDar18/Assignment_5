package com.padcmyanmar.padc9.assignment_5.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.assignment_5.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerItemViewHolder extends BaseViewHolder<HotelVO> {

    private ItemClicked itemClicked;

    @BindView(R.id.house_iv)
    ImageView house_iv;

    @BindView(R.id.price_tv)
    TextView price_tv;

    @BindView(R.id.address_tv)
    TextView address_tv;

    @BindView(R.id.square_feet_tv)
    TextView square_feet_tv;

    public RecyclerItemViewHolder(@NonNull View itemView, ItemClicked delegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);

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
        Glide.with(itemView)
                .load(data.getImage())
                .into(house_iv);
        price_tv.setText(data.getPrice());
        address_tv.setText(data.getAddress());
        square_feet_tv.setText(data.getSquare_feet());
    }
}
