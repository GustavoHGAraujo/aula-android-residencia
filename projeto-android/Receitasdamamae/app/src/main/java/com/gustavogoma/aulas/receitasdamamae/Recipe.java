package com.gustavogoma.aulas.receitasdamamae;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gustavo on 10/31/17.
 */

public class Recipe implements Serializable {

    private String title;
    private ArrayList<String> ingredients;
    private ArrayList<String> instructions;

    public Recipe() {
        this.title="";
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
