import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import org.json.JSONObject;
import java.util.Scanner;

class Weather{
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        String apiKey = "";
        System.out.print("Enter city name which weather you want : ");
        String city_name =kb.nextLine();
        String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city_name;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // System.out.println("Weather Data for " + city + ":\n");
                String value=response.body();
                JSONObject obj = new JSONObject(value);
                JSONObject location = obj.getJSONObject("location");
                String city = location.getString("name");
                String region = location.getString("region");
                String country = location.getString("country");
                JSONObject current=obj.getJSONObject("current");
                float temp=current.getFloat("temp_c");
                JSONObject condition= current.getJSONObject("condition");
                String weather=condition.getString("text");
                System.out.println("city: "+city);
                System.out.println("region: "+region);
                System.out.println("country: "+country);
                System.out.println("temp: "+temp+"*c");
                System.out.println("weather: "+weather);
            } else {
                System.out.println("Error: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}