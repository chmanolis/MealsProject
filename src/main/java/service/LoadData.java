package service;

import java.util.ArrayList;
import java.util.List;

public class LoadData {
    final private List<String> listOfCountries =new ArrayList<String>();

    public LoadData(){

    }

    public String loadCategories() {
        ApiClient countriesCall = new ApiClient(ApiClient.LIST_BY_CATEGORY);
        System.out.println(countriesCall.fetch());
        return countriesCall.fetch();
    }

}
