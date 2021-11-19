package com.example.move;



public class Movie {
    private String title;
    private String original_title;
    private String poster_path;
    private String overview;
    private String release_date;
    private String vote_average;


    public Movie(String title, String original_title, String poster_path, String overview, String release_date, String vote_average) {
        this.title = title;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_average = vote_average;


    }

    public String getTitle() {
        return title;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public String getPoster_path() { return poster_path;}
    public String getOverview() { return overview; }
    public String getRelease_date() {
        return release_date;
    }
    public String getVote_average() {return vote_average;}
}