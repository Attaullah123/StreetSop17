package com.hiconsolution.streetsop17.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiconsolution.streetsop17.R;
import com.hiconsolution.streetsop17.models.CartModel;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private static ArrayList<CartModel> cartModels;

    public CartAdapter(ArrayList<CartModel> cartModel) {
        cartModels = cartModel;
        }

        @Override

        public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
        R.layout.shopping_cart_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
        }
        @Override
        public void onBindViewHolder(CartAdapter.ViewHolder viewHolder, int position) {
        CartModel cartModel = cartModels.get(position);
            viewHolder.productStoreName.setText(cartModel.getStoreName());
            viewHolder.productCode.setText(cartModel.getProductCode());
            viewHolder.productPrice.setText(cartModel.getPrice());
            viewHolder.productVariation.setText(cartModel.getVariation());
            viewHolder.productSubtotal.setText(cartModel.getSubTotal());
            viewHolder.productImage.setImageResource(cartModel.getImage());

            viewHolder.feed = cartModel;
        }


        @Override

        public int getItemCount() {

            return cartModels.size();
        }

// inner class to hold a reference to each item of RecyclerView

    public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView productStoreName,productCode,productVariation,productPrice,productSubtotal;
    public ImageView productImage;
    //private Button storeDetail;

    public CartModel feed;

    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);

        productStoreName = (TextView) itemLayoutView.findViewById(R.id.product_store);
        productCode = (TextView) itemLayoutView.findViewById(R.id.product_id);
        productVariation = (TextView) itemLayoutView.findViewById(R.id.product_variation);
        productPrice = (TextView) itemLayoutView.findViewById(R.id.product_price);
        productSubtotal = (TextView) itemLayoutView.findViewById(R.id.product_total);

        //storeDetail = (Button) itemLayoutView.findViewById(R.id.view_product);
        productImage = (ImageView) itemLayoutView.findViewById(R.id.product_img);

//        storeDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), StoreProduct.class);
//                v.getContext().startActivity(intent);
//            }
//        });


    }

}
}
