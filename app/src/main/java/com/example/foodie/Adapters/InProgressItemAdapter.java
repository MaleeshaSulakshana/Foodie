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
import com.example.foodie.Classes.InProgressItem;
import com.example.foodie.R;

import java.util.ArrayList;

public class InProgressItemAdapter extends ArrayAdapter<InProgressItem> {

    private Context mContext;
    private int mResource;

    public InProgressItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<InProgressItem> objects) {
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

        title.setText(getItem(position).getQty() + " * " + getItem(position).getTitle());
        orderId.setText(getItem(position).getId());

        return convertView;
    }

}