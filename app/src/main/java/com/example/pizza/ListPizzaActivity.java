package com.example.pizza;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizza.adapters.PizzaAdapter;
import com.example.pizza.beans.Pizza;
import com.example.pizza.services.PizzaServices;

public class ListPizzaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView liste;
    private PizzaServices pizzaService = PizzaServices.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        liste = findViewById(R.id.liste);

        // Add sample pizzas to the service
        pizzaService.create(new Pizza("BARBECUED CHICKEN PIZZA", "3", R.mipmap.pizza1, 35, "2 boneless skinless chicken breast halves (6 ounces each), 1/4 teaspoon pepper, 1 cup barbecue sauce, divided, 1 tube (13.8 ounces) refrigerated pizza crust, 2 teaspoons olive oil, 2 cups shredded Gouda cheese, 1 small red onion, halved and thinly sliced, 1/4 cup minced fresh cilantro", "So fast and so easy with refrigerated pizza crust, these saucy, smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor.", "STEP 1: Sprinkle chicken with pepper; place on an oiled grill rack over medium heat. Grill, covered, until a thermometer reads 165°, 5-7 minutes per side, basting frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool slightly. Cut into cubes."));
        pizzaService.create(new Pizza("BRUSCHETTA PIZZA", "5", R.mipmap.pizza2, 35, "1/2 pound reduced-fat bulk pork sausage, 1 prebaked 12-inch pizza crust, 1 package (6 ounces) sliced turkey pepperoni, 2 cups shredded part-skim mozzarella cheese, 1-1/2 cups chopped plum tomatoes, 1/2 cup fresh basil leaves, thinly sliced, 1 tablespoon olive oil, 2 garlic cloves, minced, 1/2 teaspoon minced fresh thyme or 1/8 teaspoon dried thyme, 1/2 teaspoon balsamic vinegar, 1/4 teaspoon salt, 1/8 teaspoon pepper, Additional fresh basil leaves, optional", "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes, it's bound to become a family favorite.", "STEP 1: In a small skillet, cook sausage over medium heat until no longer pink; drain. Place crust on an ungreased baking sheet. Top with pepperoni, sausage and cheese. Bake at 450° for 10-12 minutes or until cheese is melted."));
        // Add more pizzas as needed...

        // Set the adapter for the ListView
        liste.setAdapter(new PizzaAdapter(this, pizzaService.findAll()));
        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final TextView idf = view.findViewById(R.id.idf);
        TextView nom = view.findViewById(R.id.nom);
        Toast.makeText(this, idf.getText().toString() + " " + nom.getText().toString(), Toast.LENGTH_SHORT).show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Veuillez choisir une option :");

        alertDialogBuilder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pizzaService.delete(pizzaService.findById(Integer.parseInt(idf.getText().toString())));
                liste.setAdapter(new PizzaAdapter(ListPizzaActivity.this, pizzaService.findAll()));
            }
        });

        alertDialogBuilder.setNegativeButton("Détails", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ListPizzaActivity.this, DetailsPizzas.class);
                intent.putExtra("idf", idf.getText().toString());
                startActivity(intent);
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}