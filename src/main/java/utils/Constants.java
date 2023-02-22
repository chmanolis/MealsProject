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

    public static final String insertIntoAreas ="Insert into MEALS.AREA values(?,?)";
    public static final String insertIntoCategories ="Insert into MEALS.CATEGORY values(?,?)";
}
