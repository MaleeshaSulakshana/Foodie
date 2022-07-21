package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.foodie.Adapters.MenuAdapter;
import com.example.foodie.Classes.FoodMenuItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnMenu;

    private ListView menuList;
    private ArrayList<FoodMenuItem> detailsArrayList = new ArrayList<>();

    private Boolean slideState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        menuList = (ListView) this.findViewById(R.id.menuList);

        btnMenu = (ImageView) this.findViewById(R.id.btnMenu);

        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) this.findViewById(R.id.navigationView);

        showDetails();

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String selected = String.valueOf(detailsArrayList.get(i).getId());

                Intent intent = new Intent(DashboardActivity.this, ItemDetailsActivity.class);
                intent.putExtra("id", selected);
                startActivity(intent);

            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    private void showDetails()
    {
        detailsArrayList.clear();
        menuList.setAdapter(null);

        MenuAdapter menuAdapter = new MenuAdapter(this, R.layout.menu_item_row, detailsArrayList);
        menuList.setAdapter(menuAdapter);

        detailsArrayList.add(new FoodMenuItem("1", "", "Chicken noodles", "Large portion of noodles with creamy chicken and extra cheese", "Rs. 150.00"));
        detailsArrayList.add(new FoodMenuItem("1", "", "Chicken noodles", "Large portion of noodles with creamy chicken and extra cheese", "Rs. 150.00"));
        detailsArrayList.add(new FoodMenuItem("1", "", "Chicken noodles", "Large portion of noodles with creamy chicken and extra cheese", "Rs. 150.00"));
        menuAdapter.notifyDataSetChanged();

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//
//            case R.id.nav_home:
////                Intent shareIntent = new Intent (Intent.ACTION_SEND);
////                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
////                shareIntent.putExtra (Intent.EXTRA_TEXT, shareBody);
////                startActivity (Intent.createChooser (shareIntent,"Share App Locker"));
//                Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
//                this.startActivity(intent);
//
//                return true;
//
//            case R.id.nav_orders:
//                Intent intent2 = new Intent(DashboardActivity.this, DashboardActivity.class);
//                this.startActivity(intent2);
//
//                return true;
//
//            case R.id.nav_account:
//
//                Intent intent3 = new Intent(DashboardActivity.this, AccountActivity.class);
//                this.startActivity(intent3);
//
//                return true;
//
//            case R.id.nav_about:
//
//                Intent intent4 = new Intent(DashboardActivity.this, AboutActivity.class);
//                this.startActivity(intent4);
//
//                return true;
//
//            case R.id.nav_faq:
//
//                System.out.println("**************");
//
//                startActivity(new Intent(DashboardActivity.this, FaqActivity.class));
//                return true;
//
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        System.out.println("**************");
//
//        return false;
//    }
}