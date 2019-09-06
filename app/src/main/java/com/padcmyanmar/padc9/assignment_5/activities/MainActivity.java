package com.padcmyanmar.padc9.assignment_5.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.adapters.TabPagerAdapter;
import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;
import com.padcmyanmar.padc9.assignment_5.delegates.ItemClicked;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ItemClicked {

    @BindView(R.id.search_iv)
    ImageView search_iv;

    @BindView(R.id.search_et)
    EditText search_et;

    @BindView(R.id.linearView)
    ImageView linearView;

    @BindView(R.id.gridView)
    ImageView gridView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;

                case R.id.navigation_dashboard:
                    return true;

                case R.id.navigation_favourite:
                    return true;

                case R.id.navigation_drive:
                    return true;

                case R.id.navigation_profile:
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        TabLayout tabLayout = findViewById(R.id.tab_Layout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onGetAllHotels(EventModel.GetEventsFromNetworkDelegate delegate) {
        eventModel.getEvents(delegate);
    }

    @Override
    public void onClickedItem(int hotelId) {
        Intent intent = DetailsActivity.newIntent(getApplicationContext(), hotelId);
        startActivity(intent);
    }

    @Override
    public void onLayoutChange(final LayoutManagerDelegate layoutManagerDelegate) {
        linearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManagerDelegate.onChangeToLinearLayout();
            }
        });

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManagerDelegate.onChangeToGridLayout();
            }
        });
    }
}
