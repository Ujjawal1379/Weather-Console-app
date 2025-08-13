 Java Weather App (Console-Based)

This is a simple Java console application that fetches and displays real-time weather information for any city entered by the user. It uses the free WeatherAPI service to retrieve data and the org.json library to parse JSON responses. The application is built with Java 11+ and uses the modern HttpClient API for making HTTP requests.

Features
- Fetch current weather by city name.
- Displays city, region, country, temperature in Celsius, and a weather condition description.
- Uses Java’s latest HttpClient for API calls.
- Simple and lightweight console interface.

Technologies Used
- Java 11 or later
- WeatherAPI (Free tier API key)
- org.json library (for JSON parsing)

How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/Ujjawal1379/Weather-Console-app.git
   cd java-weather-app
   ```
2. Get your free API key from [WeatherAPI](https://www.weatherapi.com/).
3. Open `Weather.java` and replace:
   
   String apiKey = "";
   with your actual API key.
   
5. Download the [org.json library JAR](https://mvnrepository.com/artifact/org.json/json) and place it in your project folder.
6. Compile the code:
   
   javac -cp .;json-20210307.jar Weather.java
   
   (Use `:` instead of `;` on Linux/Mac.)
7. Run the program:
   
   java -cp .;json-20210307.jar Weather
  
8. Enter a city name when prompted and see the weather details.

Example Output

Enter city name which weather you want : London
city: London
region: City of London, Greater London
country: United Kingdom
temp: 18.5*c
weather: Partly cloudy


Dependencies
- org.json library (download JAR and add to classpath)
- Internet connection to fetch weather data

 License
This project is licensed under the MIT License. You are free to use, modify, and distribute this application.

Tip: You can enhance this app by adding weather forecasts for multiple days, support for Fahrenheit, and colored console output for better visuals.
