package com.example.restuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DishDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);


        Intent intent = getIntent();

        String  name = intent.getExtras().getString("dish_name");
        TextView dishName= findViewById(R.id.nameDish);
        dishName.setText(name);


        String price = intent.getExtras().getString("dish_price");
        TextView dishPrice = findViewById(R.id.priceDish);
        dishPrice.setText(price);


        String ingredients = intent.getExtras().getString("dish_ingredients");
        TextView dishIngredients = findViewById(R.id.IngredientsDish);
        dishIngredients.setText(ingredients);


        // target to button Home
        Button Home = findViewById(R.id.DetailsToHome);
        //add eventListener go to home page
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToHome = new Intent(DishDetails.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}