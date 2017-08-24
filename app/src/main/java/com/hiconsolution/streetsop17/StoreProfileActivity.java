package com.hiconsolution.streetsop17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Attaullah Khizar on 29/07/2017.
 */

public class StoreProfileActivity extends AppCompatActivity{

    private TextView enterStore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_profile);

        enterStore = (TextView) findViewById(R.id.enter_store);

        enterStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoreProductCategory.class);
                startActivity(intent);
            }
        });
    }
}
