package Model;

import java.util.ArrayList;

public class Cocktail {
    private String name;
    private int rating;
    private int voters;
    private ArrayList<Ingredient> ingredients;

    public Cocktail(String name, int rating, int voters) {
        this.name = name;
        this.rating = rating;
        this.voters = voters;
        ingredients = new ArrayList<Ingredient>();
    }

    public void addIngredient(Ingredient ingr) {
        ingredients.add(ingr);
    }
}
