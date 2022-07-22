package com.example.foodie.Classes;

public class InProgressItem {

    String id, title, price, qty;

    public InProgressItem(String id, String title, String price, String qty) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }
}
