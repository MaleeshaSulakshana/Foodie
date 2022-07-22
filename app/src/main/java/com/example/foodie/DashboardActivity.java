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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.foodie.Adapters.MenuAdapter;
import com.example.foodie.Classes.FoodMenuItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

//    private DrawerLayout drawerLayout;
//    private NavigationView navigationView;
    private ImageView btnMenu;

    private ListView menuList;
    private ArrayList<FoodMenuItem> detailsArrayList = new ArrayList<>();

    private BottomSheetDialog menuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        menuDialog = new BottomSheetDialog(DashboardActivity.this, R.style.BottomSheetTheme);
        menuDialog.setContentView(R.layout.dialog_box_menu);

        menuList = (ListView) this.findViewById(R.id.menuList);

        btnMenu = (ImageView) this.findViewById(R.id.btnMenu);

//        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);
//        navigationView = (NavigationView) this.findViewById(R.id.navigationView);

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

                LinearLayout btnHome, btnOrders, btnClose, btnAccount, btnInfo;
                TextView btnFAQ;
                menuDialog.show();

                btnHome = (LinearLayout) menuDialog.findViewById(R.id.btnHome);
                btnOrders = (LinearLayout) menuDialog.findViewById(R.id.btnOrders);
                btnClose = (LinearLayout) menuDialog.findViewById(R.id.btnClose);
                btnAccount = (LinearLayout) menuDialog.findViewById(R.id.btnAccount);
                btnInfo = (LinearLayout) menuDialog.findViewById(R.id.btnInfo);

                btnFAQ = (TextView) menuDialog.findViewById(R.id.btnFAQ);

                btnHome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                        startActivity(intent);

                    }
                });

                btnOrders.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(DashboardActivity.this, OrderActivity.class);
                        startActivity(intent);

                    }
                });

                btnAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(DashboardActivity.this, AccountActivity.class);
                        startActivity(intent);

                    }
                });

                btnInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(DashboardActivity.this, AboutActivity.class);
                        startActivity(intent);

                    }
                });

                btnFAQ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(DashboardActivity.this, FaqActivity.class);
                        startActivity(intent);

                    }
                });

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        menuDialog.dismiss();
                    }
                });


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


}