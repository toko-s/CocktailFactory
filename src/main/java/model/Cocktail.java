package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Cocktail {
    private int id;
    private int userID;
    private String name;
    private double rating;
    private int voters;
    private List<Ingredient> ingredients;
}
