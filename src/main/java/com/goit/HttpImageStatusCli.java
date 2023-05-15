package com.goit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {
    public void askStatus() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try {
            System.out.print("Enter HTTP status code: ");
            String input = reader.readLine();
            int statusCode = Integer.parseInt(input);

            try {
                downloader.downloadStatusImage(statusCode);
            } catch (IOException e) {
                System.out.println("There is not image for HTTP status " + statusCode);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please, enter a valid number");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}