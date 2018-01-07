package com.example.webdemo;

import java.util.ArrayList;

public class Data {

   private ArrayList<Integer> scoreList = new ArrayList<>();

    private String URL;
    private Character firstCharOfString;

    //Merapar Meta Data
    private String analyseDate;
    private String firstPost;
    private String lastPost;

    private int totalPosts;
    private int totalAcceptedPosts;
    private int avgScore;


    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }

    public Character getFirstCharOfString() {
        return firstCharOfString;
    }

    public void setFirstCharOfString(Character firstCharOfString) {
        this.firstCharOfString = firstCharOfString;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts += totalPosts;
    }
    public int getTotalPosts() {
        return totalPosts;
    }

    public int getAvgScore() {
        return avgScore;
    }
    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public void AddScore(Integer s){
        scoreList.add(s);
    }

    public void GetAverageScore(){
        int total = 0;

        for(Integer i : scoreList){
            total += i;
        }

        avgScore = total / scoreList.size();
    }
}
