package service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;


public class LoadData {
    final private List<String> listOfAreas = new ArrayList<String>();
    final private List<String> listOfCategories = new ArrayList<String>();

    public LoadData() {

    }

    //load categories from URL
    public List<String> loadCategories() {
        ApiClient categoriesCall = new ApiClient(ApiClient.LIST_BY_CATEGORY);

        //System.out.println(countriesCall.fetch());
        JSONObject jsnobject = new JSONObject(categoriesCall.fetch());

        JSONArray mealsArray = jsnobject.getJSONArray("meals");
        if (mealsArray != null) {

            //Iterating JSON array
            for (int i = 0; i < mealsArray.length(); i++) {


                //Adding each element of JSON array into ArrayList
                listOfCategories.add(mealsArray.getJSONObject(i).getString("strCategory"));
            }
        }
        //System.out.println("JSON Object");
        System.out.println(mealsArray);

        System.out.println("Each element of ArrayList");
        for (String listOfCategory : listOfCategories) {
            //Printing each element of ArrayList
            System.out.println(listOfCategory);

        }
        return listOfCategories;
    }
    public List<String> LoadofAreas() {
        ApiClient areasCall = new ApiClient(ApiClient.LIST_BY_AREA);

        System.out.println(areasCall.fetch());
        JSONObject jsnobject = new JSONObject(areasCall.fetch());

        JSONArray mealsArrayAreas = jsnobject.getJSONArray("meals");
        if (mealsArrayAreas != null) {

            //Iterating JSON array
            for (int i = 0; i < mealsArrayAreas.length(); i++) {


                //Adding each element of JSON array into ArrayList
                listOfAreas.add(mealsArrayAreas.getJSONObject(i).getString("strArea"));
            }
        }
        //System.out.println("JSON Object");
        System.out.println(mealsArrayAreas);
        for (String listOfArea : listOfAreas) {
            //Printing each element of ArrayList
            System.out.println(listOfArea);

        }
        return listOfAreas;
    }
}
