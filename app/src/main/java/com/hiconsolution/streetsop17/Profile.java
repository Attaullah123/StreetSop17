package com.hiconsolution.streetsop17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Profile extends Fragment {

    private ImageView btnFb,btnTwitter,btnGoogle;
    private TextView registerAccount,forgetPassword;

    public Profile() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_activity, container, false);

        btnFb = (ImageView) rootView.findViewById(R.id.imgFaceBook);
        btnTwitter = (ImageView) rootView.findViewById(R.id.imgTwitter);
        btnGoogle = (ImageView) rootView.findViewById(R.id.imgGooglePlus);
        registerAccount = (TextView) rootView.findViewById(R.id.txtCreateAccount);
        forgetPassword = (TextView) rootView.findViewById(R.id.txtForgotPassword);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/attaullah.khizar"));
                startActivity(intent);
            }
        });

        registerAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RegisterAccount.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


}

