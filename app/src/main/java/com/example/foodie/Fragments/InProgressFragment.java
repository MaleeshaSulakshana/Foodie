package com.example.foodie.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.foodie.Adapters.CartItemAdapter;
import com.example.foodie.Adapters.InProgressItemAdapter;
import com.example.foodie.Classes.CartItem;
import com.example.foodie.Classes.InProgressItem;
import com.example.foodie.OrderTrackingActivity;
import com.example.foodie.R;

import java.util.ArrayList;

public class InProgressFragment extends Fragment {

    private ListView listView;
    private ArrayList<InProgressItem> detailsArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_in_progress, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        showDetails();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String selected = String.valueOf(detailsArrayList.get(i).getId());

                Intent intent = new Intent(getContext(), OrderTrackingActivity.class);
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

        InProgressItemAdapter inProgressItemAdapter = new InProgressItemAdapter(getContext(), R.layout.in_progress_item_row, detailsArrayList);
        listView.setAdapter(inProgressItemAdapter);

        detailsArrayList.add(new InProgressItem("9639632", "Chicken noodles", "1000", "2"));
        detailsArrayList.add(new InProgressItem("7009632", "Cheese balls", "900", "3"));
        detailsArrayList.add(new InProgressItem("9859632", "Vegetable salad", "750", "1"));
        inProgressItemAdapter.notifyDataSetChanged();

    }

}