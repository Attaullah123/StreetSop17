package com.hiconsolution.streetsop17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hiconsolution.streetsop17.adapter.BestSellerAadapter;
import com.hiconsolution.streetsop17.adapter.NewProductAdapter;
import com.hiconsolution.streetsop17.adapter.StoreProductAdapter;
import com.hiconsolution.streetsop17.models.StoreProductModel;

import java.util.ArrayList;

import static com.hiconsolution.streetsop17.R.id.recyclerView;

public class StoreProfileNew extends AppCompatActivity {
    private RecyclerView bestRecyclerView, newRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<StoreProductModel> productStoreModel;
    private Button letsShop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_profile_new);
        bestRecyclerView = (RecyclerView) findViewById(R.id.recycle_best_selling);
        newRecyclerView = (RecyclerView) findViewById(R.id.recycle_new_product);
        letsShop = (Button) findViewById(R.id.shop_button);

        bestRecyclerView.setHasFixedSize(true);
        bestRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        bestRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        bestRecyclerView.setAdapter(mAdapter);

        newRecyclerView.setHasFixedSize(true);
        newRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        newRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        newRecyclerView.setAdapter(mAdapter);

        letsShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StoreProductCategory.class);
                startActivity(intent);
            }
        });

       // final String[] name = {"product1", "product2", "product3", "product4", "product5"};
        final String[] price = {"400$.", "300$", "450$", "200$", "200$"};
        final int[] image = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

        productStoreModel = new ArrayList<StoreProductModel>();

        for (int i = 0; i < price.length; i++) {
            StoreProductModel storeProductLists = new StoreProductModel();

           // storeProductLists.setName(name[i]);
            storeProductLists.setPrice(price[i]);
            storeProductLists.setThumbnail(image[i]);
            productStoreModel.add(storeProductLists);

            mAdapter = new BestSellerAadapter(productStoreModel);

            // set the adapter object to the Recyclerview
            bestRecyclerView.setAdapter(mAdapter);

        }

        for (int i = 0; i < price.length; i++) {
            StoreProductModel storeProductLists = new StoreProductModel();

            //storeProductLists.setName(name[i]);
            storeProductLists.setPrice(price[i]);
            storeProductLists.setThumbnail(image[i]);
            productStoreModel.add(storeProductLists);

            mAdapter = new NewProductAdapter(productStoreModel);

            // set the adapter object to the Recyclerview
            newRecyclerView.setAdapter(mAdapter);

        }
    }
}