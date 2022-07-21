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
import com.example.foodie.R;

import java.util.ArrayList;

public class MenuAdapter  extends ArrayAdapter<FoodMenuItem> {

    private Context mContext;
    private int mResource;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<FoodMenuItem> objects) {
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
        TextView desc = (TextView) convertView.findViewById(R.id.desc);
        TextView price = (TextView) convertView.findViewById(R.id.price);

        title.setText(getItem(position).getTitle());
        desc.setText(getItem(position).getDesc());
        price.setText(getItem(position).getPrice());

        return convertView;
    }

}