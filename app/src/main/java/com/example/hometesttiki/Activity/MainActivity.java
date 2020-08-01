package com.example.hometesttiki.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.example.hometesttiki.Adapter.MainViewPagerAdapter;
import com.example.hometesttiki.Fragment.FragmentCaNhan;
import com.example.hometesttiki.Fragment.FragmentDanhMuc;
import com.example.hometesttiki.Fragment.FragmentThongBao;
import com.example.hometesttiki.Fragment.FragmentTimKiem;
import com.example.hometesttiki.Fragment.FragmentTrangChu;
import com.example.hometesttiki.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new FragmentTrangChu(), "Trang chủ");
        mainViewPagerAdapter.addFragment(new FragmentDanhMuc(), "Danh mục");
        mainViewPagerAdapter.addFragment(new FragmentTimKiem(), "Tìm kiểm");
        mainViewPagerAdapter.addFragment(new FragmentThongBao(), "Thông báo");
        mainViewPagerAdapter.addFragment(new FragmentCaNhan(), "Cá nhân");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tabLayout.getTabAt(0).getIcon().setTint(Color.BLUE);
        }
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_danhmuc_all_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_search_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_notifications_24);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_baseline_account_circle_24);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tabLayout.getTabAt(tab.getPosition()).getIcon().setTint(Color.BLUE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tabLayout.getTabAt(tab.getPosition()).getIcon().setTint(Color.BLACK);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void AnhXa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}