package models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MealList {
    private final List<Meal> ListOfMeals = new ArrayList<Meal>();

    public void addToMealList(Meal meal){
        ListOfMeals.add(meal);
    }
    public List<Meal>getListOfMeals(){
        return ListOfMeals;
    }
}
