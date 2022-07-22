package com.example.foodie.Classes;

public class OrderDetailsItem {

    String title, orderId, date;

    public OrderDetailsItem(String title, String orderId, String date) {
        this.title = title;
        this.orderId = orderId;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }
}
