package com.hiconsolution.streetsop17.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.hiconsolution.streetsop17.R;

import java.util.ArrayList;

/**
 * Created by cresset on 28/07/2017.
 */

public class ImageSliderAdapter extends PagerAdapter {


    private ArrayList<Integer> imagesList;

    private LayoutInflater inflater;
    private Context mContext;


    public ImageSliderAdapter(Context context, ArrayList<Integer> imagesList) {
        this.mContext = context;
        this.imagesList = imagesList;
        //this.productDetailLists = detailLists;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        final String image = imagesList.get(position).toString();

        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageViewer = (ImageView) imageLayout.findViewById(R.id.product_image_viewer);
        final ProgressBar progressBar = (ProgressBar) imageLayout.findViewById(R.id.progressBar);

        //imageView.setImageResource(imageLink.get(position));
        Glide.with(mContext).load(image).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageViewer);
        view.addView(imageLayout, 0);

//        imageLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,"click", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(v.getContext(), ShowFullImage.class);
//                intent.putExtra("picture", image);
//                mContext.startActivity(intent);
//            }
//        });
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
