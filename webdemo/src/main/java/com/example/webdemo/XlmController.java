package com.example.webdemo;


import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.stereotype.Component;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ListIterator;

import static java.lang.Integer.parseInt;

@Component
public class XlmController {

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
                        int x = Integer.parseInt(words[i]);
                        //System.out.println(x);
                        data.AddScore(x);
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
            }
        }

        data.GetAverageScore();
        System.out.println(String.valueOf(data.getTotalPosts()));
        data.setFirstCharOfString(data.getURL().charAt(0));
    }
}


