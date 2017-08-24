package com.hiconsolution.streetsop17;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiconsolution.streetsop17.adapter.ImageSliderAdapter;
import com.hiconsolution.streetsop17.adapter.StoreAdapter;
import com.hiconsolution.streetsop17.models.StoreModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class Home extends Fragment {

    View rootView;
    private ImageSliderAdapter pagerAdapter;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private CirclePageIndicator indicator;
    private static final Integer[] IMAGES= {R.drawable.slider5,R.drawable.slider2,R.drawable.slider3,R.drawable.slider4};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    //store init

    private RecyclerView recyclerView;
    private CardView cardView;

    private ArrayList<StoreModel> storeList;

    private RecyclerView.Adapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        sliderInit();
        storeInit();
        return rootView;

    }

    public void sliderInit(){

        for(int i=0;i<IMAGES.length;i++)
        ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);


        mPager.setAdapter(new ImageSliderAdapter(getContext(),ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                rootView.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4000, 4000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    //initialize store

    private void storeInit(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.cart_recycler_view);

//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle("Android Versions");
//
//        }

        final String[] versions = {"StreetShop", "StreetShop2", "StreetShop3", "StreetShop4"};
        final int[] icons = {R.drawable.slider5, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4};


        storeList = new ArrayList<StoreModel>();

        for (int i = 0; i < versions.length; i++) {
            StoreModel storeLists = new StoreModel();

            storeLists.setTitle(versions[i]);
            storeLists.setThumbnail(icons[i]);
            storeList.add(storeLists);
        }

        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new StoreAdapter(storeList);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);


}

}
