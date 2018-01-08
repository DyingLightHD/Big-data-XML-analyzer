package com.example.MeraparDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Data {

    private ArrayList<Integer> scoreList = new ArrayList<>();
    private ArrayList<Integer> answerList = new ArrayList<>();

    private String URL;
    private Character firstCharOfString;

    //Merapar Meta Data
    private String analyseDate;

    private int totalPosts;
    private int totalAnswerCount;
    private int avgAnswerCount;
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

    public String getAnalyseDate() {
        return analyseDate;
    }
    public void setAnalyseDate(String analyseDate) {
        this.analyseDate = analyseDate;
    }

    public int getTotalAnswerCount() {
        return totalAnswerCount;
    }
    public void setTotalAnswerCount() {
        this.totalAnswerCount = answerList.size();
    }

    public int getAvgAnswerCount() {
        return avgAnswerCount;
    }
    public void setAvgAnswerCount(int avgAnswerCount) {
        this.avgAnswerCount = avgAnswerCount;
    }


    public void AddScore(Integer s){
        scoreList.add(s);
    }
    public void AddAnswer(Integer a){
        answerList.add(a);
    }

    public void GetAverageScore(){

        int total = 0;

        for(Integer i : scoreList){
            total += i;
        }

        avgScore = total / scoreList.size();
    }
    public void GetAverageAnswer(){

        int total = 0;

        for(Integer i : answerList){
            total += i;
        }

        avgAnswerCount = total / answerList.size();
    }
}
