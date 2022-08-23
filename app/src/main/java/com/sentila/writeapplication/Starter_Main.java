package com.sentila.writeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;

public class Starter_Main extends AppCompatActivity {
    // 플래그먼트를 연결해줄 어댑터를 전역변수로 선언해줍니다
    FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_WriteApplication);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_main);

        //페이지에서 플래그먼를 보여주기 위해 연결해주는 코드입니다
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);
    }

    //플래그먼트 어댑터를 연결해주는 오작교 클래스 코드입니다
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        //보여줄 페이지를 3으로 지정해주었습니다
        private static int NUM_ITEMS = 3;
        //뷰페이저와 인디케이터를 연결해주는 코드입니다

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            //각 페이지를 불러오는 코드이고 저는 따로 여기서 호출할때 페이지 번호를 사용하지는 않았습니다.
            switch (position) {
                case 0:
                    return Starter_first.newInstance(0, "Page # 1");
                case 1:
                    return Starter_second.newInstance(1, "Page # 2");
                case 2:
                    return Starter_third.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}