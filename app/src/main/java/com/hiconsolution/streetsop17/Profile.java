package com.hiconsolution.streetsop17;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Profile extends Fragment {

    public Profile() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
//        btnFb = (ImageButton) rootView.findViewById(R.id.btn_facebook);
//        btnTwitter = (ImageButton) rootView.findViewById(R.id.btn_twitter);
//        btnInsta = (ImageButton) rootView.findViewById(R.id.btn_insta);
//        btnGoogle = (ImageButton) rootView.findViewById(R.id.btn_gmail);
//        btnLinkdin = (ImageButton) rootView.findViewById(R.id.btn_linkedin);
//        btnRss = (ImageButton) rootView.findViewById(R.id.btn_no);
//
//        btnFb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/attaullah.khizar"));
//                startActivity(intent);
//            }
//        });

        return rootView;
    }


}

