package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    AppDataBase  appDataBase ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       //get data from database and show it as list of dish using recycleView
        appDataBase =  Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "dish_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        DishDao dishDao = appDataBase.dishDao();
        List<Dish> allDish = dishDao.getAll();

        RecyclerView allDishRecycleView = findViewById(R.id.dishRecycleView);
        allDishRecycleView.setLayoutManager(new LinearLayoutManager(this));
        allDishRecycleView.setAdapter(new DishAdapter(allDish));



        // target to button Home
        Button Home = findViewById(R.id.MenuToHome);
        //add eventListener go to home page
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToHome = new Intent(Menu.this, MainActivity.class);
                startActivity(goToHome);
            }
        });


    }
}