package com.example.circkett20live;

public class Team {
    private String score;
    private String overs;
    private String imageUri;
    private String countryName;
    private String currentSituation;
    private String matchType;
    private  String status;

    // Required empty constructor for Firebase
    public Team() {
    }

    public Team(String currentSituation,String matchType,String status,String score, String overs, String imageUri, String countryName) {
        this.score = score;
        this.overs = overs;
        this.currentSituation= currentSituation;
        this.matchType= matchType;
        this.status=status;
        this.imageUri = imageUri;
        this.countryName = countryName;
    }

    public String getCurrentSituation() {
        return currentSituation;
    }

    public String getMatchType() {
        return matchType;
    }

    public String getStatus() {
        return status;
    }

    public String getScore() {
        return score;
    }

    public String getOvers() {
        return overs;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getCountryName() {
        return countryName;
    }
}
