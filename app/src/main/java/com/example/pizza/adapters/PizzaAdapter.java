package com.example.pizza.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pizza.R;
import com.example.pizza.beans.Pizza;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Pizza> pizzas;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Pizza> pizzas) {
        this.pizzas = pizzas;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.general_item, null);

        TextView idf = convertView.findViewById(R.id.idf);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView nbrIngredients = convertView.findViewById(R.id.nbrIndegredients);
        ImageView photo = convertView.findViewById(R.id.photo);

        Pizza pizza = pizzas.get(position);

        idf.setText(String.valueOf(pizza.getId()));
        nom.setText(pizza.getNom());
        nbrIngredients.setText(pizza.getNbringredients());
        duree.setText(String.valueOf(pizza.getDuree()));
        photo.setImageResource(pizza.getPhoto());

        return convertView;
    }
}