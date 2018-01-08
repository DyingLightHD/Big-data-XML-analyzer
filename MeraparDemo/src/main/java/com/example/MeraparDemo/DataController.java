package com.example.MeraparDemo;

import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@Component
public class DataController {


    public void analyzeData(Data data) {

        String urlString = data.getURL();
        Boolean getNextValue = false;
        String getNextValueString = "";

        try {
            URL url = new URL(urlString);

            URLConnection urlConnection = url.openConnection();

            HttpURLConnection connection = null;

            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            } else {
                System.out.println("Please enter an HTTP URL.");
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String current;

            while ((current = in.readLine()) != null) {
                urlString += current;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = urlString.split("=|\\s");

        for (int i = 0; i < words.length; i++) {

            words[i] = words[i].replace("\"","");

            if (getNextValue)
                switch (getNextValueString) {
                    case "Score":
                        int s = Integer.parseInt(words[i]);
                        data.AddScore(s);
                        getNextValue = false;
                        break;
                    case "AnswerCount":
                        int a = Integer.parseInt(words[i]);
                        data.AddAnswer(a);
                        getNextValue = false;
                        break;
                }

            switch (words[i]) {
                case "PostTypeId":
                    data.setTotalPosts(1);
                    break;
                case "Score":
                    getNextValue = true;
                    getNextValueString = "Score";
                    break;
                case "AnswerCount":
                    getNextValue = true;
                    getNextValueString = "AnswerCount";
                    break;
            }
        }

        data.GetAverageScore();
        data.GetAverageAnswer();
        data.setTotalAnswerCount();

        System.out.println(String.valueOf(data.getTotalPosts()));
        data.setFirstCharOfString(data.getURL().charAt(0));
    }
}
