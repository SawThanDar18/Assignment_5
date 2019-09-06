package com.padcmyanmar.padc9.assignment_5.views.holders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.assignment_5.delegates.ItemClicked;
import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerItemViewHolder extends BaseViewHolder<HotelVO> {

    public Context context;

    private ItemClicked itemClicked;

    @BindView(R.id.house_iv)
    ImageView house_iv;

    @BindView(R.id.price_tv)
    TextView price_tv;

    @BindView(R.id.address_tv)
    TextView address_tv;

    @BindView(R.id.square_feet_tv)
    TextView square_feet_tv;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton map_fb;

    public RecyclerItemViewHolder(@NonNull View itemView, ItemClicked delegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        itemClicked = delegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClicked.onClickedItem(mData.getId());
            }
        });

        map_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lattitude = mData.getLattitude();
                double longitude = mData.getLongitude();

                String uriBegin = "geo:" + lattitude + "," + longitude;
                String query = lattitude + "," + longitude + "(" + mData.getName() + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                context.startActivity(mapIntent);
            }
        });
    }

    @Override
    public void bindData(HotelVO data) {

        mData = data;

        Glide.with(itemView).load(data.getImage()).into(house_iv);
        price_tv.setText(String.valueOf(data.getPrice()));
        address_tv.setText(data.getAddress());
        square_feet_tv.setText(String.valueOf(data.getSquare_feet()));
    }
}
