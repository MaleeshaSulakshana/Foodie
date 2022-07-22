package com.example.foodie.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.foodie.Adapters.MenuAdapter;
import com.example.foodie.Adapters.OrderDetailsItemAdapter;
import com.example.foodie.Classes.FoodMenuItem;
import com.example.foodie.Classes.OrderDetailsItem;
import com.example.foodie.OrderConfirmActivity;
import com.example.foodie.OrderTrackingActivity;
import com.example.foodie.R;

import java.util.ArrayList;

public class OrderDetailsFragment extends Fragment {

    private ListView listView;
    private ArrayList<OrderDetailsItem> detailsArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_details, container, false);


        listView = (ListView) view.findViewById(R.id.listView);

        showDetails();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String selected = String.valueOf(detailsArrayList.get(i).getOrderId());

                Intent intent = new Intent(getContext(), OrderConfirmActivity.class);
                intent.putExtra("id", selected);
                startActivity(intent);

            }
        });

        return view;
    }

    private void showDetails()
    {
        detailsArrayList.clear();
        listView.setAdapter(null);

        OrderDetailsItemAdapter orderDetailsItemAdapter = new OrderDetailsItemAdapter(getContext(), R.layout.order_details_item_row, detailsArrayList);
        listView.setAdapter(orderDetailsItemAdapter);

        detailsArrayList.add(new OrderDetailsItem("Chicken noodles", "9639632", "5th May 2022"));
        detailsArrayList.add(new OrderDetailsItem("Cheese balls", "7009632", "5th April 2022"));
        detailsArrayList.add(new OrderDetailsItem("Vegetable salad", "9639932", "5th April 2022"));
        orderDetailsItemAdapter.notifyDataSetChanged();

    }

}