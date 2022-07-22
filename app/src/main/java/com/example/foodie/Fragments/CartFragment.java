package com.example.foodie.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.foodie.Adapters.CartItemAdapter;
import com.example.foodie.Adapters.OrderDetailsItemAdapter;
import com.example.foodie.Classes.CartItem;
import com.example.foodie.Classes.FoodMenuItem;
import com.example.foodie.Classes.OrderDetailsItem;
import com.example.foodie.GetStartActivity;
import com.example.foodie.MainActivity;
import com.example.foodie.OrderConfirmActivity;
import com.example.foodie.PaymentActivity;
import com.example.foodie.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private ListView listView;
    private Button btnPay;
    private ArrayList<CartItem> detailsArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        btnPay = (Button) view.findViewById(R.id.btnPay);

        showDetails();

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), PaymentActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

    private void showDetails()
    {
        detailsArrayList.clear();
        listView.setAdapter(null);

        CartItemAdapter cartItemAdapter = new CartItemAdapter(getContext(), R.layout.cart_item_row, detailsArrayList);
        listView.setAdapter(cartItemAdapter);

        detailsArrayList.add(new CartItem("9639632", "Chicken noodles", "1000", "2"));
        detailsArrayList.add(new CartItem("7009632", "Cheese balls", "900", "3"));
        detailsArrayList.add(new CartItem("9859632", "Vegetable salad", "750", "1"));
        cartItemAdapter.notifyDataSetChanged();

    }

}