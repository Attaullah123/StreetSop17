package com.hiconsolution.streetsop17.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.StoreProduct;
import com.hiconsolution.streetsop17.StoreProfileActivity;
import com.hiconsolution.streetsop17.models.ProductCategoryModel;
import com.hiconsolution.streetsop17.models.ProductCategoryModel;

import java.util.ArrayList;



public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder> {


private static ArrayList<ProductCategoryModel> categoryModels;

public ProductCategoryAdapter(ArrayList<ProductCategoryModel> categoryModel) {

    categoryModels = categoryModel;
        }


@Override
public ProductCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
// create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
        R.layout.category_product_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ProductCategoryAdapter.ViewHolder viewHolder, int i) {

        ProductCategoryModel productCategoryModel = categoryModels.get(i);

        viewHolder.productCategoryName.setText(productCategoryModel.getName());
        viewHolder.productCategorydetail.setText(productCategoryModel.getDetail());

    viewHolder.productCategoryImage.setImageResource(productCategoryModel.getThumbnail());
        viewHolder.feed = productCategoryModel;
        }

@Override
public int getItemCount() {
        return categoryModels.size();
        }

// inner class to hold a reference to each item of RecyclerView
public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView productCategoryName,productCategorydetail;
    public ImageView productCategoryImage;
    private Button storeDetail;

    public ProductCategoryModel feed;

    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);

        productCategoryName = (TextView) itemLayoutView.findViewById(R.id.product_category_name);
        productCategorydetail = (TextView) itemLayoutView.findViewById(R.id.product_category_detail);
        storeDetail = (Button) itemLayoutView.findViewById(R.id.view_product);
        productCategoryImage = (ImageView) itemLayoutView.findViewById(R.id.product_category_image);

        storeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StoreProduct.class);
                v.getContext().startActivity(intent);
            }
        });

        itemLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), StoreProduct.class);
                v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(), "os version is: " + feed.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}
}
