package controllers;

import models.Meal;
import views.MealView;

public class MealController {
    private Meal model;
    private MealView view;
    public MealController(Meal model, MealView view){
        this.model = model;
        this.view = view;
    }
}
