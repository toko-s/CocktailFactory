package model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@ToString
public class Ingredient {
    private String name;
    private double weight;
    private double price;

    public Ingredient(String name) {
        this.name = name;
    }
    public Ingredient() {

    }
    public String getName() {
        return name;
    }
}
