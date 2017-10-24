package com.hiconsolution.streetsop17;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hiconsolution.streetsop17.adapter.ProductCategoryAdapter;
import com.hiconsolution.streetsop17.adapter.StoreProductAdapter;
import com.hiconsolution.streetsop17.models.StoreProductModel;
import com.hiconsolution.streetsop17.models.StoreProductModel;

import java.util.ArrayList;


public class StoreProduct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<StoreProductModel> productStoreModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_products);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mAdapter);

        final String[] name = {"product1", "product2", "product3", "product4","product5"};
        final String[] price = {"400$.", "300$", "450$", "200$","200$"};
        final int[] image = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5};

        productStoreModel = new ArrayList<StoreProductModel>();

        for (int i = 0; i < name.length; i++) {
            StoreProductModel storeProductLists = new StoreProductModel();

            storeProductLists.setName(name[i]);
            storeProductLists.setPrice(price[i]);
            storeProductLists.setThumbnail(image[i]);
            productStoreModel.add(storeProductLists);

            mAdapter = new StoreProductAdapter(productStoreModel);

            // set the adapter object to the Recyclerview
            recyclerView.setAdapter(mAdapter);

        }
    }
}
