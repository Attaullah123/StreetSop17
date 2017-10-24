package com.hiconsolution.streetsop17.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hiconsolution.streetsop17.FinaliseOrderTablayout;
import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.adapter.CartAdapter;
import com.hiconsolution.streetsop17.models.CartModel;

import java.util.ArrayList;

public class PaymentFragment extends Fragment{
    View rootView;


   public PaymentFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.payment_fragment, container, false);

        return rootView;
    }


}
