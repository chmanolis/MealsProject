package service;

import models.Meal;
import models.MealList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FetchMealFromApi {
    final private List<String> listOfAreas = new ArrayList<String>();
    final private List<String> listOfCategories = new ArrayList<String>();
    public Meal getMealFromApi(@NotNull String mealName) {
        String url;
        if (mealName.equals("random")) {
            url = ApiClient.RANDOM_MEAL_URL;
        } else {
            url = ApiClient.SEARCH_BY_NAME_URL + mealName;
        }
        ApiClient fetchMealByName = new ApiClient(url);
        JSONObject jsnobject = new JSONObject(fetchMealByName.fetch());
        System.out.println(jsnobject);

        if (jsnobject.get("meals").equals(null)) {
            System.out.println("Meal not Found. Please try another name");
            return null;
        } else {
            JSONArray mealsArray = jsnobject.getJSONArray("meals");
            int id = Integer.parseInt(mealsArray.getJSONObject(0).getString("idMeal"));
            String name = mealsArray.getJSONObject(0).getString("strMeal");
            String category = mealsArray.getJSONObject(0).getString("strCategory");
            String area = mealsArray.getJSONObject(0).getString("strArea");
            String instructions = mealsArray.getJSONObject(0).getString("strInstructions");
            System.out.println(id + " " + name + " " + category + " " + area + " " + instructions);
            return new Meal(id, name, category, area, instructions,0);
        }
    }
     public List<String> getCategoriesAPI() {
        ApiClient categoriesCall = new ApiClient(ApiClient.LIST_BY_CATEGORY);


        JSONObject jsnobject = new JSONObject(categoriesCall.fetch());
        JSONArray mealsArray = jsnobject.getJSONArray("meals");
        if (mealsArray != null) {
            //Iterating JSON array
            for (int i = 0; i < mealsArray.length(); i++) {
                //Adding each element of JSON array into ArrayList
                listOfCategories.add(mealsArray.getJSONObject(i).getString("strCategory"));
            }
        }
        for (String listOfCategory : listOfCategories) {
            //Printing each element of ArrayList
            System.out.println(listOfCategory);
        }
        return listOfCategories;
    }
    public List<String> getAreasAPI() {
        ApiClient areasCall = new ApiClient(ApiClient.LIST_BY_AREA);
        JSONObject jsnobject = new JSONObject(areasCall.fetch());
        JSONArray mealsArrayAreas = jsnobject.getJSONArray("meals");
        if (mealsArrayAreas != null) {
            //Iterating JSON array
            for (int i = 0; i < mealsArrayAreas.length(); i++) {
                //Adding each element of JSON array into ArrayList
                listOfAreas.add(mealsArrayAreas.getJSONObject(i).getString("strArea"));
            }
        }
        for (String listOfArea : listOfAreas) {
            //Printing each element of ArrayList
            System.out.println(listOfArea);
        }
        return listOfAreas;
    }

}