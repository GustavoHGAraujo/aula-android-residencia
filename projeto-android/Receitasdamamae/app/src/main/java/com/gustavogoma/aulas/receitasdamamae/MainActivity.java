package com.gustavogoma.aulas.receitasdamamae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Request de novas receitas
    private static final int REQUEST_NEW_RECIPE = 1;

    private ArrayList<Recipe> recipes;

    private void newRecipe(){
        // Chamando a Activity RecipeActivity para criar uma nova receita
        Intent i = new Intent(this, RecipeActivity.class);
        this.startActivityForResult(i, REQUEST_NEW_RECIPE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipes = new ArrayList<>();

        this.findViewById(R.id.fab).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Verifica qual o request
        switch(requestCode) {
            case REQUEST_NEW_RECIPE:
                // Se o resultado for OK, pega a instancia e adiciona na lista de receitas
                if (resultCode == RESULT_OK) {
                    Recipe r = (Recipe) data.getSerializableExtra("recipe");
                    recipes.add(r);
                    // Mostra todas as receitas criadas
                    Log.v("MainActivity", java.util.Arrays.toString(recipes.toArray(new Recipe[0])));
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        // Verifica qual view chamou o onClick
        switch(view.getId()){
            // Faz a ação relacionada ao FloatingActionButton
            case R.id.fab:
                newRecipe();
                break;
        }
    }
}
