package com.example.hometesttiki.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.hometesttiki.Adapter.MyBannerAdapter;
import com.example.hometesttiki.Adapter.MyQuickLinkAdapter;
import com.example.hometesttiki.Adapter.MySaleAdapter;
import com.example.hometesttiki.Callback.RetrofitClient;
import com.example.hometesttiki.Common.Common;
import com.example.hometesttiki.Model.DataBanner;
import com.example.hometesttiki.Model.DataQuickLink;
import com.example.hometesttiki.Model.QuickLink;
import com.example.hometesttiki.Model.Sale;
import com.example.hometesttiki.R;
import com.example.hometesttiki.Retrofit.ITikiAPI;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.relex.circleindicator.CircleIndicator;

public class FragmentTrangChu extends Fragment {

    ITikiAPI iTikiAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    Handler handler;
    Runnable runnable;
    private int currentItem;
    RecyclerView recy_Quick_Link_1, recy_Quick_Link_2, recy_sale;
    SwipeRefreshLayout refresh_home;
    ProgressBar progress_Bar_Banner, progress_Bar_Quick_Link, progress_Bar_Sale_Load;
    Thread t1;

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenttrangchu,container,false);

        //Init
        iTikiAPI = Common.getAPI();
        viewPager = view.findViewById(R.id.myViewPagerBanner);
        circleIndicator = view.findViewById(R.id.indicator_banner);
        recy_Quick_Link_1 = view.findViewById(R.id.recy_quick_link_1);
        recy_Quick_Link_2 = view.findViewById(R.id.recy_quick_link_2);
        recy_sale = view.findViewById(R.id.recy_sale);
        progress_Bar_Banner = view.findViewById(R.id.progress_bar_banner);
        progress_Bar_Quick_Link = view.findViewById(R.id.progress_bar_quick_link);
        progress_Bar_Sale_Load = view.findViewById(R.id.progress_bar_sale_load);
        refresh_home = view.findViewById(R.id.refresh_home);
        refresh_home.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_blue_light,
                android.R.color.holo_orange_dark);
        refresh_home.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(Common.isConnectedToInternet(getContext())){
                    fetchBanner();
                }else{
                    Toast.makeText(getContext(), "Cannot connect to INTERNET", Toast.LENGTH_SHORT).show();
                }
            }
        });
        refresh_home.post(new Runnable() {
            @Override
            public void run() {
                if(Common.isConnectedToInternet(getContext())){
                    fetchBanner();
                }else{
                    Toast.makeText(getContext(), "Cannot connect to INTERNET", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void fetchSale() {
        compositeDisposable.add(iTikiAPI.getSale()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Sale>() {
                    @Override
                    public void accept(Sale sale) throws Exception {
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
                        recy_sale.setLayoutManager(layoutManager);
                        recy_sale.setAdapter(new MySaleAdapter(getContext(), sale.getData()));
                        refresh_home.setRefreshing(false);
                        progress_Bar_Sale_Load.setVisibility(View.INVISIBLE);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getContext(), "Tải giảm giá thất bại!", Toast.LENGTH_SHORT).show();
                        refresh_home.setRefreshing(false);
                    }
                }));
    }

    private void fetchQuickLink() {
        compositeDisposable.add(iTikiAPI.getDataQuickLink()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataQuickLink>() {
                    @Override
                    public void accept(DataQuickLink dataQuickLink) throws Exception {
                        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                        recy_Quick_Link_1.setLayoutManager(layoutManager1);
                        recy_Quick_Link_2.setLayoutManager(layoutManager2);
                        recy_Quick_Link_1.setAdapter(new MyQuickLinkAdapter(getContext(), dataQuickLink.getData().get(0)));
                        recy_Quick_Link_2.setAdapter(new MyQuickLinkAdapter(getContext(), dataQuickLink.getData().get(1)));
                        fetchSale();
                        progress_Bar_Quick_Link.setVisibility(View.INVISIBLE);
                        progress_Bar_Sale_Load.setVisibility(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getContext(), "Lỗi tải quick link!", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private void fetchBanner() {
        compositeDisposable.add(iTikiAPI.getDataBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataBanner>() {
                    @Override
                    public void accept(DataBanner data) throws Exception {
                        viewPager.setAdapter(new MyBannerAdapter(data.getData(), getContext()));
                        circleIndicator.setViewPager(viewPager);
                        handler = new Handler();
                        runnable = new Runnable() {
                            @Override
                            public void run() {
                                currentItem = viewPager.getCurrentItem();
                                currentItem++;
                                if(currentItem>=viewPager.getAdapter().getCount()){
                                    currentItem = 0;
                                }
                                viewPager.setCurrentItem(currentItem, true);
                                handler.postDelayed(runnable, 2000);
                            }
                        };
                        handler.postDelayed(runnable, 2000);
                        fetchQuickLink();
                        progress_Bar_Banner.setVisibility(View.INVISIBLE);
                        progress_Bar_Quick_Link.setVisibility(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getContext(), "Lỗi tải quảng cáo" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }));
    }
}
