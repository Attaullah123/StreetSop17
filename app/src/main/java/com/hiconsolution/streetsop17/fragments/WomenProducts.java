package com.hiconsolution.streetsop17.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiconsolution.streetsop17.R;

/**
 * Created by cresset on 07/08/2017.
 */

public class WomenProducts extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.women_products, container,false);
        return view;

    }
}
