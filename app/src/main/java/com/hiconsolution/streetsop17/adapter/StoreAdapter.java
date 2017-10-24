package com.hiconsolution.streetsop17.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.StoreProfileActivity;
import com.hiconsolution.streetsop17.StoreProfileNew;
import com.hiconsolution.streetsop17.models.ParentModelIndexModel;

import java.util.ArrayList;


public class StoreAdapter  extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private static ArrayList<ParentModelIndexModel> dataSet;
    private Context mContext;

    public StoreAdapter(Context context, ArrayList<ParentModelIndexModel> parentModelList) {
        this.mContext =context;
        this.dataSet = parentModelList;
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

        ParentModelIndexModel fp = dataSet.get(i);

        viewHolder.tvVersionName.setText(fp.getName());
        Glide.with(mContext).load(fp.getImageLink()).into(viewHolder.categoryImage);
        viewHolder.feed = fp;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvVersionName;
        public ImageView categoryImage;

        public ParentModelIndexModel feed;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvVersionName = (TextView) itemLayoutView.findViewById(R.id.store_name);
            categoryImage = (ImageView) itemLayoutView.findViewById(R.id.store_image);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), StoreProfileNew.class);
                    v.getContext().startActivity(intent);
                    //Toast.makeText(v.getContext(), "os version is: " + feed.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
}
