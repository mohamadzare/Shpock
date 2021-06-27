package com.example.shpock.Models;

public class ships {

    private int id;
    private int price;
    private String title;
    private String description;
    private String image;
    private String greeting_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGreeting_type() {
        return greeting_type;
    }

    public void setGreeting_type(String greeting_type) {
        this.greeting_type = greeting_type;
    }
}
