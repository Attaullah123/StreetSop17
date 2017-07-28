package com.hiconsolution.streetsop17.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.models.StoreModel;

import java.util.ArrayList;

/**
 * Created by cresset on 28/07/2017.
 */

public class StoreAdapter  extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private static ArrayList<StoreModel> dataSet;

    public StoreAdapter(ArrayList<StoreModel> os_versions) {

        dataSet = os_versions;
    }


    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.store_card_design, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoreAdapter.ViewHolder viewHolder, int i) {

        StoreModel fp = dataSet.get(i);

        viewHolder.tvVersionName.setText(fp.getTitle());
        viewHolder.iconView.setImageResource(fp.getThumbnail());
        viewHolder.feed = fp;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVersionName;
        public ImageView iconView;

        public StoreModel feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView.findViewById(R.id.store_name);
            iconView = (ImageView) itemLayoutView.findViewById(R.id.store_image);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    Intent intent = new Intent(v.getContext(), SecondPage.class);
//                    v.getContext().startActivity(intent);
                    Toast.makeText(v.getContext(), "os version is: " + feed.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}
