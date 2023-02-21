package service;

import models.Meal;
import models.MealList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FetchMealFromApi {
    public Meal getMealFromApi(String mealName) {
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
            return new Meal(id, name, category, area, instructions);
        }
    }
    public getCountries<String>


}