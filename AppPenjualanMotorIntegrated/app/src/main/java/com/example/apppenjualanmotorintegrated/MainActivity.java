package com.example.apppenjualanmotorintegrated;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


public class MainActivity extends AppCompatActivity {

    private final int NUM_PAGES = 4;
    private ViewPager2 pager;
    private String sendVal = "id";
    private MeowBottomNavigation bottomNavigation;
    private ScreenSlidePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        adapter = new ScreenSlidePagerAdapter(this);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        pager.setAdapter(adapter);

        pager.setCurrentItem(1);
        pager.setUserInputEnabled(false);

        bottomNavigation.show(2,true);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_add));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_list));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_laporan));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()) {
                    case 1 :
                        pager.setCurrentItem(0);
                        break;
                    case 2 :
                        pager.setCurrentItem(1);
                        break;
                    case 3 :
                        pager.setCurrentItem(2);
                        break;
                    default:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });
    }
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0 :
                    return new MainActivityInputData();
                case 1 :
                    return new MainActivityList();
                case 2 :
                    return new MainActivityLaporan();
                default:
                    return new MainActivityList();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}