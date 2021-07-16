package model;

import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Setter
@ToString
public class Cocktail {
    private String name;
    private double rating;
    private int voters;
    private ArrayList<Ingredient> ingredients;

    public Cocktail() {
        ingredients = new ArrayList<Ingredient>();
    }

    public void addIngredient(Ingredient ingr) {
        ingredients.add(ingr);
    }
}
