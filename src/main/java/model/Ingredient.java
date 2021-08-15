package model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ingredient {
    private Integer id;
    private String name;

    public Ingredient (String name){
        this.name = name;
    }
}
