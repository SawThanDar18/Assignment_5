package com.padcmyanmar.padc9.assignment_5.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.adapters.TabPagerAdapter;
import com.padcmyanmar.padc9.assignment_5.data.models.EventModel;
import com.padcmyanmar.padc9.assignment_5.data.vos.HotelVO;

public class ForYouFragment extends Fragment {

    EditText search_et;

    public ForYouFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_for_you, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = view.findViewById(R.id.tab_Layout);
        ViewPager viewPager = view.findViewById(R.id.viewPager);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        search_et = view.findViewById(R.id.search_et);

        search_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {

                }
                return false;
            }
        });

        search_et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_DEL) {
                }
                return false;
            }
        });

        search_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchByKeyWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void searchByKeyWord(String keyword){
        keyword = search_et.getText().toString();
        //if(keyword.toLowerCase().contains())
    }
}
