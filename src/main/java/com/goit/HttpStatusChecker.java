package com.goit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new IOException("Image not found for status code " + code);
        }

        return url;
    }

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String imageUrl = checker.getStatusImage(404);
            System.out.println("Image URL: " + imageUrl);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String imageUrl = checker.getStatusImage(10000);
            System.out.println("Image URL: " + imageUrl);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}