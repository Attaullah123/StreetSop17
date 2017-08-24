package com.hiconsolution.streetsop17.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hiconsolution.streetsop17.fragments.BillingShippingFragment;
import com.hiconsolution.streetsop17.fragments.ConfirmationFragment;
import com.hiconsolution.streetsop17.fragments.PaymentFragment;

/**
 * Created by cresset on 21/08/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BillingShippingFragment tab1 = new BillingShippingFragment();
                return tab1;
            case 1:
                PaymentFragment tab2 = new PaymentFragment();
                return tab2;
            case 2:
                ConfirmationFragment tab3 = new ConfirmationFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}