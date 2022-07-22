package com.example.foodie.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodie.Classes.FoodMenuItem;
import com.example.foodie.Classes.OrderDetailsItem;
import com.example.foodie.R;

import java.util.ArrayList;

public class OrderDetailsItemAdapter extends ArrayAdapter<OrderDetailsItem> {

    private Context mContext;
    private int mResource;

    public OrderDetailsItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<OrderDetailsItem> objects) {
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
        TextView orderId = (TextView) convertView.findViewById(R.id.orderId);
        TextView orderDate = (TextView) convertView.findViewById(R.id.orderDate);

        title.setText(getItem(position).getTitle());
        orderId.setText("Order Id : " + getItem(position).getOrderId());
        orderDate.setText("Date : " + getItem(position).getDate());

        return convertView;
    }

}