package com.hiconsolution.streetsop17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.adapter.CartAdapter;
import com.hiconsolution.streetsop17.adapter.StoreProductAdapter;
import com.hiconsolution.streetsop17.models.CartModel;
import com.hiconsolution.streetsop17.models.StoreProductModel;

import java.util.ArrayList;


public class ShoppingCart extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<CartModel> cartModel;
    private Button checkout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        checkout = (Button) findViewById(R.id.btnCheckOut);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mAdapter);

        final String[] storeName = {"store1", "store2", "store3", "store4","store5"};
        final String[] productName = {"product1", "product2", "product3", "product4","product5"};
        final String[] productPrice = {"400$.", "300$", "450$", "200$","200$"};
        final String[] productVariation = {"1.", "2", "4", "2","5"};
        final String[] productSubTotal = {"400$.", "300$", "450$", "200$","200$"};
        final int[] image = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image5};

        cartModel = new ArrayList<CartModel>();

        for (int i = 0; i < storeName.length; i++) {
            CartModel cartLists = new CartModel();

            cartLists.setStoreName(storeName[i]);
            cartLists.setProductCode(productName[i]);
            cartLists.setPrice(productPrice[i]);
            cartLists.setVariation(productVariation[i]);
            cartLists.setSubTotal(productSubTotal[i]);

            cartLists.setImage(image[i]);
            cartModel.add(cartLists);
            mAdapter = new CartAdapter(cartModel);

            // set the adapter object to the Recyclerview
            recyclerView.setAdapter(mAdapter);

            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),FinaliseOrderTablayout.class);
                    startActivity(intent);
                }
            });
        }
    }
}
