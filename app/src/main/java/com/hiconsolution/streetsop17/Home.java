package com.hiconsolution.streetsop17;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hiconsolution.streetsop17.adapter.ImageSliderAdapter;
import com.hiconsolution.streetsop17.adapter.StoreAdapter;
import com.hiconsolution.streetsop17.models.ParentModelIndexModel;
import com.hiconsolution.streetsop17.models.StoreIndexCategoryList;
import com.hiconsolution.streetsop17.utility.Config;
import com.hiconsolution.streetsop17.volley.AppController;
import com.viewpagerindicator.CirclePageIndicator;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;



public class Home extends Fragment {

    View rootView;
    private ImageSliderAdapter pagerAdapter;
    private ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    public CirclePageIndicator indicator;
    private static final Integer[] IMAGES= {R.drawable.slider5,R.drawable.slider2,R.drawable.slider3,R.drawable.slider4};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    //store init
    private RecyclerView recyclerView;
    private CardView cardView;
    private StoreAdapter storeAdapter;
    private ArrayList<StoreIndexCategoryList> storeList;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        sliderInit();
        storeInit();
        getStoreCategoryList();

        return rootView;

    }

    public void sliderInit(){

        for(int i=0;i<IMAGES.length;i++)
        ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) rootView.findViewById(R.id.pager12);
        progressBar=(ProgressBar) rootView.findViewById(R.id.progressBar);

//       // mPager.setAdapter(ImagesArray);
//
//
//        indicator = (CirclePageIndicator) rootView.findViewById(R.id.indicator12);
//        indicator.setViewPager(mPager);
//
//        final float density = getResources().getDisplayMetrics().density;
//
////Set circle indicator radius
//        indicator.setRadius(5 * density);
//
//        NUM_PAGES =IMAGES.length;
//
//        // Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 4000, 4000);
//
//        // Pager listener over indicator
//        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int position) {
//                currentPage = position;
//
//            }
//
//            @Override
//            public void onPageScrolled(int pos, float arg1, int arg2) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int pos) {
//
//            }
//        });
    }

    //initialize store

    private void storeInit(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(storeAdapter);
}

    public  void getStoreCategoryList(){
        progressBar.setVisibility(View.VISIBLE);
        Map<String, String> params = new HashMap<String, String>();
        params.put("ProjectId", "1");
        params.put("ParentId", "0");


        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, Config.URL_INDEX_CATEGORY, new JSONObject(params), new
                Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("data", response.toString());
                        Gson gson = new Gson();
                        StoreIndexCategoryList storeIndexCategoryList = gson.fromJson(response.toString(), new TypeToken<StoreIndexCategoryList>(){}.getType());
                        ArrayList<ParentModelIndexModel> parentModelIndexModels = new ArrayList<ParentModelIndexModel>(storeIndexCategoryList.getParentlist());

                        storeAdapter = new StoreAdapter(getContext(), parentModelIndexModels);
                        recyclerView.setAdapter(storeAdapter);
                        progressBar.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), "Couldn't feed refresh, check connection", Toast.LENGTH_SHORT).show();
                Log.d("Error", error.toString());

                progressBar.setVisibility(View.GONE);

            }
        });

        AppController.getInstance().addToRequestQueue(objectRequest);
}

}
