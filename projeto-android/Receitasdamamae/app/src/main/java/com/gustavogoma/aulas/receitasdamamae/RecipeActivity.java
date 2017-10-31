package com.gustavogoma.aulas.receitasdamamae;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gustavo on 10/31/17.
 */

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener {

    private void save(){
        Recipe r = new Recipe();
        EditText title = (EditText) this.findViewById(R.id.title);
        EditText ingredients = (EditText) this.findViewById(R.id.ingredients);
        EditText instructions = (EditText) this.findViewById(R.id.instructions);

        r.setTitle(title.getText().toString());
        r.getIngredients().add(ingredients.getText().toString());
        r.getInstructions().add(instructions.getText().toString());

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("recipe", r);

        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        this.findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                save();
                break;
        }
    }
}
