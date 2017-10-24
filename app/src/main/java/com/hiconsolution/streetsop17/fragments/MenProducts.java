package com.hiconsolution.streetsop17.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.adapter.ProductCategoryAdapter;
import com.hiconsolution.streetsop17.models.ProductCategoryModel;

import java.util.ArrayList;

public class MenProducts extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private ArrayList<ProductCategoryModel> productCategoryModel;

    private RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.men_products, container,false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setTitle("Android Versions");
//
//        }

        final String[] name = {"product1", "product2", "product3", "product4","product5"};
        final String[] detail = {"Lorem Ipsum is simply dummy text of the printing and typesetting industry.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                , "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.","Lorem Ipsum is simply dummy text of the printing and typesetting industry."};
        final int[] image = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5};


        productCategoryModel = new ArrayList<ProductCategoryModel>();

        for (int i = 0; i < name.length; i++) {
            ProductCategoryModel productLists = new ProductCategoryModel();

            productLists.setName(name[i]);
            productLists.setDetail(detail[i]);
            productLists.setThumbnail(image[i]);
            productCategoryModel.add(productLists);
        }



        //Grid View
        // recyclerView.setLayoutManager(new GridLayoutManager(this,2,1,false));

        //StaggeredGridView
        // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // create an Object for Adapter
        mAdapter = new ProductCategoryAdapter(productCategoryModel);

        // set the adapter object to the Recyclerview
        recyclerView.setAdapter(mAdapter);

        return rootView;

    }
}
