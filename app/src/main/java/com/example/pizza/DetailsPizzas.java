package com.example.pizza;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizza.beans.Pizza;
import com.example.pizza.services.PizzaServices;

public class DetailsPizzas extends AppCompatActivity {
    private PizzaServices pizzaService;
    private ImageView image;
    private TextView desc;
    private TextView nom;
    private TextView ingredients;
    private TextView preparation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pizzas);


        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("idf"));


        pizzaService = PizzaServices.getInstance();


        image = findViewById(R.id.photo);
        nom = findViewById(R.id.nom);
        desc = findViewById(R.id.description);
        ingredients = findViewById(R.id.detailsIngred);



        Pizza pizza = pizzaService.findById(id);


        if (pizza != null) {
            image.setImageResource(pizza.getPhoto());
            nom.setText(pizza.getNom());
            desc.setText(pizza.getDescription());
            ingredients.setText(pizza.getDetailsIngred());
            preparation.setText(pizza.getPreparation());
        }
    }
}