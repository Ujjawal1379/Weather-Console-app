# Java Weather App (Console-Based)

This is a simple Java console application that fetches and displays real-time weather information for any city entered by the user.  
It uses the free [WeatherAPI](https://www.weatherapi.com/) service to retrieve data and the `org.json` library (already included in the repository) to parse JSON responses.  
The application is built with Java 11+ and uses the modern `HttpClient` API for making HTTP requests.

---

## Features
- Fetch current weather by city name.
- Displays:
  - City
  - Region
  - Country
  - Temperature in Celsius
  - Weather condition description
- Uses Java’s latest HttpClient for API calls.
- Simple and lightweight console interface.

---

## Technologies Used
- Java 11 or later
- WeatherAPI (Free tier API key)
- org.json library (already included in repository)

---

## How to Run
1. **Clone this repository:**
   ```bash
   git clone https://github.com/Ujjawal1379/Weather-Console-app.git
   cd Weather-Console-app
   ```
2. **Get your free API key** from [WeatherAPI](https://www.weatherapi.com/).
3. **Open `Weather.java`** and replace:
   ```java
   String apiKey = "";
   ```
   with your actual API key.
4. **Compile the code** (org.json JAR is already in repo):
   ```bash
   javac -cp ".;lib/json-20250517.jar" Weather.java
   ```
   *(Use `:` instead of `;` on Linux/Mac.)*
5. **Run the program**:
   ```bash
   java -cp ".;lib/json-20250517.jar" Weather
   ```
6. **Enter a city name** when prompted and see the weather details.

---

## Example Output
```
Enter city name which weather you want : London
city: London
region: City of London, Greater London
country: United Kingdom
temp: 18.5*c
weather: Partly cloudy
```

---

## Code Explanation

### 1. **Import Statements**
```java
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import org.json.JSONObject;
import java.util.Scanner;
```
- `HttpClient`, `HttpRequest`, and `HttpResponse` → Modern Java classes for sending HTTP requests and receiving responses.
- `URI` → Used to create the API URL object.
- `org.json.JSONObject` → To parse JSON data from the API response.
- `Scanner` → To take city name input from the user.

---

### 2. **User Input**
```java
Scanner kb = new Scanner(System.in);
System.out.print("Enter city name which weather you want : ");
String city_name = kb.nextLine();
```
- The program asks the user to enter a city name and stores it in `city_name`.

---

### 3. **API URL Setup**
```java
String url = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city_name;
```
- Constructs the API URL using the provided API key and user input.

---

### 4. **Sending the HTTP Request**
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
```
- Creates an HTTP client.
- Builds a GET request to the API.
- Sends the request and stores the response as a string.

---

### 5. **Parsing JSON Response**
```java
JSONObject obj = new JSONObject(response.body());
JSONObject location = obj.getJSONObject("location");
JSONObject current = obj.getJSONObject("current");
JSONObject condition = current.getJSONObject("condition");
```
- Converts the API’s JSON response into Java objects for easy data access.

---

### 6. **Extracting and Displaying Data**
```java
String city = location.getString("name");
String region = location.getString("region");
String country = location.getString("country");
float temp = current.getFloat("temp_c");
String weather = condition.getString("text");
```
- Extracts the relevant details and prints them.

---

## Dependencies
- `org.json` library (already included in this repository)
- Internet connection to fetch weather data

---

## License
This project is licensed under the **MIT License**. You are free to use, modify, and distribute this application.

---

**💡 Tip:** You can enhance this app by adding:
- Multi-day forecasts
- Fahrenheit temperature option
- Colored console output for better visuals
