package models;

public class Meal {
    private  final int mealId;
    //strMeal
    private final String mealName;
    //strCategoty
    private final String category;
    //strArea
    private final String area;
    //strInstructions
    private  String instructions;

    public Meal(int mealId, String n, String c, String a, String i) {
        this.mealId = mealId;
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
    public int getMealId(){
        return this.mealId;

    }
    public String getInstructions(){
        return this.instructions;
    }
    public void setInstructions(String instructions){
        this.instructions=instructions;
    }


}
