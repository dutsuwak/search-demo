package com.search.demo.controller;

public class Movie {

    private String name = "-";
    private String year = "-";
    private String rate = "-";
    private String votes = "-";
    private String genre = "-";
    private String duration = "-";
    private String certificate = "-";
    private String type = "-";
    private String episodes = "-";
    private String nudity = "-";
    private String violence = "-";
    private String profanity = "-";
    private String alcohol = "-";
    private String frightening = "-";

    public Movie(){

    }

    public Movie(String name, String year, String rate, String votes, String genre, String duration,
                 String type, String certificate, String episodes, String nudity, String violence,
                 String profanity, String alcohol, String frightening){

        this.name = name;
        this.year = year;
        this.rate = rate;
        this.votes = votes;
        this.genre = genre;
        this.duration = duration;
        this.certificate =  certificate;
        this.type = type;
        this.episodes = episodes;
        this.nudity = nudity;
        this.violence = violence;
        this.profanity = profanity;
        this.alcohol = alcohol;
        this.frightening = frightening;
    }

    /* Setters */
    public void setName(String name){ this.name = name; }
    public void setYear(String year){ this.year = year; }
    public void setRate(String rate){ this.rate = rate; }
    public void setVotes(String votes){ this.votes = votes; }
    public void setGenre(String genre){ this.genre = genre; }
    public void setDuration(String duration){ this.duration = duration; }
    public void setCertificate(String certificate){ this.certificate = certificate; }
    public void setType(String type){ this.type = type; }
    public void setEpisodes(String episodes){ this.episodes = episodes; }
    public void setNudity(String nudity){ this.nudity = nudity; }
    public void setViolence(String violence){ this.violence = violence; }
    public void setProfanity(String profanity){ this.profanity = profanity; }
    public void setAlcohol(String alcohol){ this.alcohol = alcohol; }
    public void setFrightening(String frightening){ this.frightening = frightening; }

    /* Getters */
    public String getName(){ return this.name; }
    public String getYear(){ return this.year; }
    public String getRate(){ return this.rate; }
    public String getVotes(){ return this.votes; }
    public String getGenre(){ return this.genre; }
    public String getDuration(){ return this.duration; }
    public String getCertificate(){ return this.certificate; }
    public String getType(){ return this.type; }
    public String getEpisodes(){ return this.episodes; }
    public String getNudity(){ return this.nudity; }
    public String getViolence(){ return this.violence; }
    public String getProfanity(){ return this.profanity; }
    public String getAlcohol(){ return this.alcohol; }
    public String getFrightening(){ return this.frightening; }

}
