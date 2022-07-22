package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PaymentActivity extends AppCompatActivity {

    private ImageView btnBack;
    private Dialog confirmOrderDialog;
    private Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirmOrderDialog = new Dialog(PaymentActivity.this);
        confirmOrderDialog.setContentView(R.layout.dialog_box_confirm_order);

        btnBack = (ImageView) this.findViewById(R.id.btnBack);
        btnConfirmOrder = (Button) this.findViewById(R.id.btnConfirmOrder);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PaymentActivity.this, OrderActivity.class);
                startActivity(intent);

            }
        });

        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmOrderDialog.show();

                Button btnKeep = (Button) confirmOrderDialog.findViewById(R.id.btnKeep);
                Button btnTrack = (Button) confirmOrderDialog.findViewById(R.id.btnTrack);

                btnKeep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PaymentActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    }
                });

                btnTrack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(PaymentActivity.this, OrderTrackingActivity.class);
                        startActivity(intent);

                    }
                });

            }
        });

    }
}