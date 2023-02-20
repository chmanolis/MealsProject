package models;

public class Meal {
    //strMeal
    private final String mealName;
    //strCategoty
    private final String category;
    //strArea
    private final String area;
    //strInstructions
    private final String instructions;

    public Meal(String n, String c,String a,String i) {
        this.mealName = n;
        this.category=c;
        this.area=a;
        this.instructions=i;

    }
    public String getMealName(){
        return this.mealName;
    }
    public String getCategory(){
        return this.category;

    }
    public String getArea(){
        return this.area;

    }
    public String getInstructions(){
        return this.instructions;
    }


}
