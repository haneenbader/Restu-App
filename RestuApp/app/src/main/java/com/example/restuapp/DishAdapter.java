package com.example.restuapp;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// 1- Create the class without extensions ..
// 6- Extend RecyclerView.Adapter - StudentAdapter.StudentViewHolder
public class DishAdapter extends  RecyclerView.Adapter<DishAdapter.DishViewHolder>{

    // 2- create the list the the adapter will use to bind data
    List<Dish> allDish = new ArrayList<>();

    // generate constructor
    public DishAdapter(List<Dish> allDish) {
        this.allDish = allDish;
    }



    // 3- create the ViewHolder class (Wraps the data and the view)
    public  static  class DishViewHolder extends RecyclerView.ViewHolder {
        // 4- The model object
        public Dish dish ;
        // 5- view object
        View itemView ;
        // + setting the itemView value
        //generate constructor
        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToDetails = new Intent(v.getContext(),DishDetails.class);
                    goToDetails.putExtra("dish_name",dish.name );
                    goToDetails.putExtra("dish_price",Integer.toString(dish.price));
                    goToDetails.putExtra("dish_ingredients", dish.ingredients);
                    v.getContext().startActivity(goToDetails);

                }
            });

        }
    }


    //    impliment after extend class
    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 7- create the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish_item,parent,false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder ;
    }
    //    impliment after extend class
    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        holder.dish = allDish.get(position);
        TextView name = holder.itemView.findViewById(R.id.dishNameFragment);
        TextView price = holder.itemView.findViewById(R.id.dishPriceFragment);
//        TextView ingredients = holder.itemView.findViewById(R.id.dishIngredientFragment);
//

        name.setText(holder.dish.name);
        price.setText(Integer.toString(holder.dish.price));
//        ingredients.setText(holder.dish.ingredients);


    }
    //    impliment after extend class
    @Override
    public int getItemCount() {
        return allDish.size();
    }


}
