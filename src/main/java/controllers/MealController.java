package controllers;

import models.Meal;
import views.MealView;

public class MealController {
    private final Meal model;
    private MealView view;
    public MealController(Meal model, MealView view){
        this.model = model;
        this.view = view;
    }
    public Meal getMealDetails(){
        return model;
    }
    public void setMealInstructions(String instructions){
        model.setInstructions(instructions);
    }
    public void updateView(){
        view.printMealDetails(model);
    }
}

