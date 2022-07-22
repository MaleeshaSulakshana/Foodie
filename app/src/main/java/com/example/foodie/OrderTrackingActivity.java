package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.foodie.Adapters.InProgressItemAdapter;
import com.example.foodie.Classes.InProgressItem;

import java.util.ArrayList;

public class OrderTrackingActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<InProgressItem> detailsArrayList = new ArrayList<>();

    private ImageView btnBack;
    private LinearLayout txtConfirmReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);

        listView = (ListView) this.findViewById(R.id.listView);

        btnBack = (ImageView) this.findViewById(R.id.btnBack);

        txtConfirmReceived = (LinearLayout) this.findViewById(R.id.txtConfirmReceived);

        showDetails();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OrderTrackingActivity.this, OrderActivity.class);
                startActivity(intent);

            }
        });

        txtConfirmReceived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OrderTrackingActivity.this, OrderConfirmActivity.class);
                startActivity(intent);

            }
        });

    }

    private void showDetails()
    {
        detailsArrayList.clear();
        listView.setAdapter(null);

        InProgressItemAdapter inProgressItemAdapter = new InProgressItemAdapter(OrderTrackingActivity.this, R.layout.in_progress_item_row, detailsArrayList);
        listView.setAdapter(inProgressItemAdapter);

        detailsArrayList.add(new InProgressItem("9639632", "Chicken noodles", "1000", "2"));
        detailsArrayList.add(new InProgressItem("7009632", "Cheese balls", "900", "3"));
        detailsArrayList.add(new InProgressItem("9859632", "Vegetable salad", "750", "1"));
        inProgressItemAdapter.notifyDataSetChanged();

    }

}