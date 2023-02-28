package controllers;

import models.Meal;
import service.AppDatabase;
import service.FetchMealFromApi;

public class MealController {
    FetchMealFromApi fmapi=new FetchMealFromApi();
    AppDatabase appDB= new AppDatabase();
    private Meal meal;

    public MealController(){

    }

    public Meal getMealDetails(){
        return this.meal;
    }
    public void searchForMeal(String meanName){
        this.meal=fmapi.getMealFromApi(meanName);
        if(this.meal.getMealName() != null) {
            AppDatabase.addMeal(this.meal);
            AppDatabase.updateMealViews(this.meal);
            this.meal = AppDatabase.fetchMealDB(this.meal);
        }

    }

    public void setMealInstructions(String instructions){
        meal.setInstructions(instructions);
        AppDatabase.updateMealDetails(meal);
    }

}

