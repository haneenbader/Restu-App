package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        // target to button Home
        Button Home = findViewById(R.id.AddDishToHome);
        //add eventListener go to home page
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToHome = new Intent(AddDish.this, MainActivity.class);
                startActivity(goToHome);
            }
        });


        
        EditText  dishNameText = findViewById(R.id.dishNameInput);
        EditText  dishPriceText = findViewById(R.id.dishPriceInput);
        EditText dishIngredients = findViewById(R.id.dishIngredientsInput);

        Button Submit = findViewById((R.id.submitButton));
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dish dish =new Dish(dishNameText.getText().toString() , Integer.parseInt(dishPriceText.getText().toString()) , dishIngredients.getText().toString());

                AppDataBase appDataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "dish_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
                DishDao dishDao = appDataBase.dishDao();

                dishDao.insertAll(dish);
            }
        });

    }
}