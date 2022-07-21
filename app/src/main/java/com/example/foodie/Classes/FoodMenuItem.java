package com.example.foodie.Classes;

public class FoodMenuItem {

    String id, image, title, desc, price;

    public FoodMenuItem(String id, String image, String title, String desc, String price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }
}
