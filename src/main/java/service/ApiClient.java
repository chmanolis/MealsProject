
package service;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiClient {


    public static final String BASE_URL = "www.themealdb.com/api/json/v1/1/random.php";
    public static final String SEARCH_BY_NAME_URL = BASE_URL+"search.php?s=";
    public static final String SEARCH_BY_FIRST_LETTER_URL = BASE_URL+"search.php?f=";
    public static final String FULL_MEAL_DETAILS_URL = BASE_URL+"lookup.php?i=";







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
