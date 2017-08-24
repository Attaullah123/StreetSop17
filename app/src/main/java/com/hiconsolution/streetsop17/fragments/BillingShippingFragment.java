package com.hiconsolution.streetsop17.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.hiconsolution.streetsop17.R;

/**
 * Created by cresset on 21/08/2017.
 */

public class BillingShippingFragment extends Fragment implements View.OnClickListener{

    private ExpandableRelativeLayout expandableBilling,expandableShipping;
    private ImageView billingPlus,billingMinus,shippingPlus,shippingMinus;
    View rootView;
    //private Unbinder unbinder;
    public BillingShippingFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.shipping_billing_fragment, container, false);

        expandableBilling = (ExpandableRelativeLayout) rootView.findViewById(R.id.expandableLayoutBillingInfo);
        expandableShipping = (ExpandableRelativeLayout) rootView.findViewById(R.id.expandableLayoutShippingInfo);
        billingPlus = (ImageView) rootView.findViewById(R.id.imgBillingInfoPlus);
        billingMinus = (ImageView) rootView.findViewById(R.id.imgBillingInfoMinus);
        shippingPlus = (ImageView) rootView.findViewById(R.id.imgSippingInfoPlus);
        shippingMinus = (ImageView) rootView.findViewById(R.id.imgSippingInfoMinus);

        expandableShipping.collapse();
        //expandableLayoutBillingInfo.expand();
        billingPlus.setOnClickListener(this);
        billingMinus.setOnClickListener(this);
        shippingPlus.setOnClickListener(this);
        shippingMinus.setOnClickListener(this);

        expandableBilling.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                billingMinus.setVisibility(View.VISIBLE);
                billingPlus.setVisibility(View.GONE);
            }

            @Override
            public void onPreClose() {
                billingMinus.setVisibility(View.GONE);
                billingPlus.setVisibility(View.VISIBLE);
            }
        });

        expandableShipping.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                shippingMinus.setVisibility(View.VISIBLE);
                shippingPlus.setVisibility(View.GONE);
            }

            @Override
            public void onPreClose() {
                shippingMinus.setVisibility(View.GONE);
                shippingPlus.setVisibility(View.VISIBLE);
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBillingInfoMinus:
                expandableBilling.collapse();
                break;
            case R.id.imgBillingInfoPlus:
                expandableBilling.expand();
                break;
            case R.id.imgSippingInfoMinus:
                expandableShipping.collapse();
                break;
            case R.id.imgSippingInfoPlus:
                expandableShipping.expand();
                break;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

}
