
package service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiClient {


    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    public static final String SEARCH_BY_NAME_URL = BASE_URL + "search.php?s=";

    public static final String RANDOM_MEAL_URL = BASE_URL + "random.php";

    public static final String LIST_BY_CATEGORY = BASE_URL + "list.php?c=list";
    public static final String LIST_BY_AREA = BASE_URL + "list.php?a=list";


    public static final String FILTER_BY_CATEGORY = BASE_URL + "filter.php?c=";


    private final OkHttpClient client;
    private final Request request;

    public ApiClient(String URL) {
        this.client = new OkHttpClient();
        this.request = new Request.Builder().url(URL).build();

    }

    public String fetch() {
        String jsonResponse = null;
        try (Response response = client.newCall(request).execute()) {

            if (response.isSuccessful() && response.body() != null) {
                jsonResponse = response.body().string();
            }
        } catch (IOException ex) {
            Logger.getLogger(ApiClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return jsonResponse;
        }
    }
}
