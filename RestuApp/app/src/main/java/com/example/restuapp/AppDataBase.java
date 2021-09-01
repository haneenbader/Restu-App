package com.example.restuapp;


import androidx.room.Database;
import androidx.room.RoomDatabase;


// connection between database and Dish class

    @Database(entities = {Dish.class}, version = 1)
    public abstract class AppDataBase extends RoomDatabase {
        public abstract DishDao dishDao();
    }


