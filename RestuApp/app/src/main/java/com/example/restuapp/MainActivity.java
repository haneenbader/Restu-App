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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // target to button Add Dish
        Button addDish = findViewById(R.id.addDish);
        //add eventListener go to add dish page
        addDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToAddDish = new Intent(MainActivity.this, AddDish.class);
                startActivity(goToAddDish);
            }
        });

        // target to button Menu
        Button menu = findViewById(R.id.menu);
        //add eventListener go to menu page
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToMenu = new Intent(MainActivity.this, Menu.class);
                startActivity(goToMenu);
            }
        });

    }




}