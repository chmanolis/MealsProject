package utils;

public class Constants {
    //API and URL
    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    public static final String SEARCH_BY_NAME_URL = BASE_URL+"search.php?s=";
    public static final String SEARCH_BY_FIRST_LETTER_URL = BASE_URL+"search.php?f=";
    public static final String FULL_MEAL_DETAILS_URL = BASE_URL+"lookup.php?i=";
    public static final String RANDOM_MEAL_URL = BASE_URL+"random.php";
    public static final String MEAL_CATEGORIES_URL = BASE_URL+"categories.php";

    public static final String LIST_BY_CATEGORY = BASE_URL+"list.php?c=list";
    public static final String LIST_BY_AREA  = BASE_URL+"list.php?a=list";
    public static final String  LIST_BY_INGREDIENTS= BASE_URL+"list.php?i=list";
    public static final String FILTER_BY_MAIN_INGREDIENT = BASE_URL+"filter.php?i=";
    public static final String FILTER_BY_CATEGORY = BASE_URL+"filter.php?c=";
    public static final String FILTER_BY_MAIN_AREA = BASE_URL+"filter.php?a=";
    //Database
    public static final String connectionString = "jdbc:derby:derbydemo3;create=true";
    //QUERIES
    public static final String checkAreaIfExistQ = "Select AREA_NAME from MEALS.AREA where AREA_NAME=?";
    public static final String checkCategoryifExistQ = "Select CATEGORY_NAME from MEALS.CATEGORY where CATEGORY_NAME=?";
    public static final String checkMealifExistQ = "Select MEAL_NAME from MEALS.MEAL where MEAL_NAME=?";

    public static final String insertIntoAreas ="Insert into MEALS.AREA values(?,?)";
    public static final String insertIntoCategories ="Insert into MEALS.CATEGORY values(?,?)";
    public static final String searchForCategory ="Select CATEGORY_ID from MEALS.CATEGORY where CATEGORY_NAME =?";
    public static final String searchForArea ="Select AREA_ID from MEALS.AREA where AREA_NAME =?";

    public static final String insertIntoMeals ="Insert into MEALS.MEAL values(?,(SELECT AREA_ID FROM MEALS.AREA WHERE AREA_NAME=?),(SELECT CATEGORY_ID FROM MEALS.CATEGORY WHERE CATEGORY_NAME=?),?,?,0)";
    public static final String updateMealDetails ="Update MEALS.MEAL Set MEAL.INSTRUCTIONS=? where MEAL_NAME=?";
    public static final String fetchMealViews ="SELECT VIEWS FROM MEALS.MEAL WHERE MEAL.MEAL_NAME=?";
    public static final String updateMealViews = "Update MEALS.MEAL Set MEALS.MEAL.VIEWS=MEALS.MEAL.VIEWS+1 where MEALS.MEAL.MEAL_NAME=?";

public static final String getMealDetailsFromDB = "select MEAL_ID,MEAL_NAME,AREA_NAME,CATEGORY_NAME,INSTRUCTIONS,VIEWS from MEALS.MEAL" +
        "    LEFT JOIN MEALS.AREA A on A.AREA_ID = MEALS.MEAL.AREA_ID" +
        "    left join MEALS.CATEGORY C on C.CATEGORY_ID = MEALS.MEAL.CATEGORY_ID" +
        "         where MEALS.MEAL.MEAL_NAME = ?";





}
