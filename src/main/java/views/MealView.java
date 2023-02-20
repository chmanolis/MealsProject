package views;

import models.Meal;

public class MealView {
    public void printMealDetails(Meal meal){
        System.out.println("Meal name is :"+meal.getMealName());
        System.out.println("Meal category is :"+meal.getCategory());
        System.out.println("Meal Area of origin is :"+meal.getArea());
        System.out.println("Instructions: \n"+meal.getInstructions());
    }
}

