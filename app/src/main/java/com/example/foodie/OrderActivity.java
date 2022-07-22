package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodie.Adapters.FPAdapter;
import com.example.foodie.Fragments.CartFragment;
import com.example.foodie.Fragments.InProgressFragment;
import com.example.foodie.Fragments.OrderDetailsFragment;
import com.google.android.material.tabs.TabLayout;

public class OrderActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tabLayout = (TabLayout) this.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) this.findViewById(R.id.viewPager);

        btnBack = (ImageView) this.findViewById(R.id.btnBack);

        tabLayout.setupWithViewPager(viewPager);

        FPAdapter fpAdapter = new FPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fpAdapter.addFragment(new InProgressFragment(), "In Progress");
        fpAdapter.addFragment(new OrderDetailsFragment(), "Order Details");
        fpAdapter.addFragment(new CartFragment(), "Cart");

        viewPager.setAdapter(fpAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OrderActivity.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

    }
}