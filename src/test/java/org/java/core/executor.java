package org.java.core;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class executor {
    private static URL URL;
    private String METHOD;
    private String PAYLOAD;
    private static JsonNode RESPONSE;
    private String HEADERS;
    public static void getRequest(String url, String method, String payload){
        try {
            URL URL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) URL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonResponse = mapper.readTree(response.toString());
                System.out.println(jsonResponse.toPrettyString());
            } else {
                System.out.println("GET request not worked. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object getRequest(String url, String method){

        try {
            URL URL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) URL.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonResponse = mapper.readTree(response.toString());
                RESPONSE = jsonResponse;
                return jsonResponse;
            } else {
                System.out.println("GET request not worked. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
