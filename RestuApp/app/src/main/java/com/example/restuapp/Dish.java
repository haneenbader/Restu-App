package com.example.restuapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public int dishId;
    @ColumnInfo(name = "dish_name")
    public  String name ;

    @ColumnInfo(name = "dish_price")
     public  int price = 0  ;
    @ColumnInfo(name = "dish_ingredients")
     public  String ingredients ;

    public Dish(){}

    public  Dish( String name ,int price , String ingredients ) {
    this.name = name ;
    this.price =price ;
    this.ingredients = ingredients ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }


}
