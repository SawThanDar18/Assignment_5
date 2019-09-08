package com.padcmyanmar.padc9.assignment_5.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {

    public static final String EXTRA_ID_EXTRA = "hotelIdExtra";

    public static Intent newIntent(Context context, int hotelIdExtra){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_ID_EXTRA, hotelIdExtra);
        return intent;
    }

    /*@BindView(R.id.detail_image)
    ImageView detail_image;*/

    @BindView(R.id.detail_price_tv)
    TextView detail_price_tv;

    @BindView(R.id.detail_address_tv)
    TextView detail_address_tv;

    @BindView(R.id.detail_sqft_tv)
    TextView detail_sqft_tv;

    @BindView(R.id.detail_name_tv)
    TextView detail_name_tv;

    @BindView(R.id.detail_description_tv)
    TextView detail_description_tv;

    @BindView(R.id.map_fb)
    FloatingActionButton map_fb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        ImageView back_iv = findViewById(R.id.back_iv);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final int hotelId = getIntent().getIntExtra(EXTRA_ID_EXTRA, 0);

        final HotelVO hotelVO = eventModel.findEventById(hotelId);
        bindData(hotelVO);

        map_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  lattitude = String.valueOf(hotelVO.getLattitude());
                String  longitude = String.valueOf(hotelVO.getLongitude());
                String openInMapPrefix = "google.navigation:q=" + lattitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(openInMapPrefix));
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void bindData(HotelVO hotelVO){
        //Glide.with(detail_image).load(hotelVO.getImage()).into(detail_image);
        detail_price_tv.setText(String.valueOf(hotelVO.getPrice()));
        detail_address_tv.setText(hotelVO.getAddress());
        detail_sqft_tv.setText(String.valueOf(hotelVO.getSquare_feet()));
        detail_name_tv.setText(hotelVO.getName());
        detail_description_tv.setText(hotelVO.getDescription());
    }
}
