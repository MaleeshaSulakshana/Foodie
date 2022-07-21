package com.example.foodie;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDetailsActivity extends AppCompatActivity {

    private Dialog addToCartDialog;
    private Button btnAddToCart;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        addToCartDialog = new Dialog(ItemDetailsActivity.this);
        addToCartDialog.setContentView(R.layout.dialog_box_add_to_cart);

        btnAddToCart = (Button) this.findViewById(R.id.btnAddToCart);
        spinner = (Spinner) this.findViewById(R.id.portionSelect);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addToCartDialog.show();

                Button btnKeep = (Button) addToCartDialog.findViewById(R.id.btnKeep);
                Button btnCart = (Button) addToCartDialog.findViewById(R.id.btnCart);

                btnKeep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addToCartDialog.dismiss();
                    }
                });

                btnCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addToCartDialog.dismiss();
                    }
                });

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView)parentView.getChildAt(0)).setTextColor(getColor(R.color.orange3));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}