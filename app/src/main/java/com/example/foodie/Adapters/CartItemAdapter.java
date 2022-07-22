package com.example.foodie.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodie.Classes.CartItem;
import com.example.foodie.Classes.OrderDetailsItem;
import com.example.foodie.R;

import java.util.ArrayList;

public class CartItemAdapter extends ArrayAdapter<CartItem> {

    private Context mContext;
    private int mResource;

    public CartItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CartItem> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView txtQty = (TextView) convertView.findViewById(R.id.txtQty);

        title.setText(getItem(position).getTitle());
        price.setText("Rs : " + getItem(position).getPrice());
        txtQty.setText(getItem(position).getQty());

        return convertView;
    }

}