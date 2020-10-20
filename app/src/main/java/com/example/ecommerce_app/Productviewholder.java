package com.example.ecommerce_app.ViewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce_app.Intefaces.Itemclicklistener;
import com.example.ecommerce_app.R;

public class Productviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textViewproductname;
    public TextView textViewproductdes;
    public TextView textViewprice;
   public ImageView imageView;
    Itemclicklistener listener;

    public Productviewholder(@NonNull View itemView) {
        super(itemView);

        textViewproductname=itemView.findViewById(R.id.product_name);
        textViewproductdes=itemView.findViewById(R.id.product_description);
        textViewprice=itemView.findViewById(R.id.product_price);
        imageView=itemView.findViewById(R.id.product_image);

    }

    @Override
    public void onClick(View view) {

        listener.onclick(view,getAdapterPosition(),false);

    }

    public void setitemlistener(Itemclicklistener itemclicklistener){

        listener=itemclicklistener;
    }

}
