package utils;

public class Constants {
    //Database
    public static final String connectionString = "jdbc:derby:derbydemo3;create=true";
    //QUERIES
    public static final String checkAreaIfExistQ = "Select AREA_NAME from MEALS.AREA where AREA_NAME=?";
    public static final String checkCategoryifExistQ = "Select CATEGORY_NAME from MEALS.CATEGORY where CATEGORY_NAME=?";
    public static final String checkMealifExistQ = "Select MEAL_NAME from MEALS.MEAL where MEAL_NAME=?";

    public static final String insertIntoAreas ="Insert into MEALS.AREA values(?,?)";
    public static final String insertIntoCategories ="Insert into MEALS.CATEGORY values(?,?)";


    public static final String insertIntoMeals ="Insert into MEALS.MEAL values(?,(SELECT AREA_ID FROM MEALS.AREA WHERE AREA_NAME=?),(SELECT CATEGORY_ID FROM MEALS.CATEGORY WHERE CATEGORY_NAME=?),?,?,0)";
    public static final String updateMealDetails ="Update MEALS.MEAL Set MEAL.INSTRUCTIONS=? where MEAL_NAME=?";

    public static final String updateMealViews = "Update MEALS.MEAL Set MEALS.MEAL.VIEWS=MEALS.MEAL.VIEWS+1 where MEALS.MEAL.MEAL_NAME=?";

public static final String getMealDetailsFromDB = "select MEAL_ID,MEAL_NAME,AREA_NAME,CATEGORY_NAME,INSTRUCTIONS,VIEWS from MEALS.MEAL" +
        "    LEFT JOIN MEALS.AREA A on A.AREA_ID = MEALS.MEAL.AREA_ID" +
        "    left join MEALS.CATEGORY C on C.CATEGORY_ID = MEALS.MEAL.CATEGORY_ID" +
        "         where MEALS.MEAL.MEAL_NAME = ?";

public static final String getStatsFromDB = "select MEAL_ID,MEAL_NAME,AREA_NAME,CATEGORY_NAME,INSTRUCTIONS,VIEWS from MEALS.MEAL" +
        "LEFT JOIN MEALS.AREA A on A.AREA_ID = MEALS.MEAL.AREA_ID" +
        "left join MEALS.CATEGORY C on C.CATEGORY_ID = MEALS.MEAL.CATEGORY_ID" +
        "ORDER BY MEAL.VIEWS DESC";





}
