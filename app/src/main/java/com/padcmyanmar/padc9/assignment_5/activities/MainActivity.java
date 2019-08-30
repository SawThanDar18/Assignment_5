package com.padcmyanmar.padc9.assignment_5.activities;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.padcmyanmar.padc9.assignment_5.R;
import com.padcmyanmar.padc9.assignment_5.fragments.ForYouFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    goToFragment(new ForYouFragment());

                case R.id.navigation_dashboard:
                    goToFragment(new ForYouFragment());

                case R.id.navigation_favourite:
                    goToFragment(new ForYouFragment());

                case R.id.navigation_drive:
                    goToFragment(new ForYouFragment());

                case R.id.navigation_profile:
                    goToFragment(new ForYouFragment());

                /*case R.id.navigation_more:
                    mTextMessage.setText(R.string.title_more);
                    return true;*/
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        goToFragment(new ForYouFragment());
    }

    private void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
    }

}
