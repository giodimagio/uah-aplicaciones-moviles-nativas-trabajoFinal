package com.uah.trabajofinal.domain.model;

import androidx.annotation.NonNull;

public class PeliculaApiResponse {

    private String Title;
    private String Year;
    private String Runtime;
    private String Country;
    private String Director;
    private String Actors;
    private String Plot;
    private String Poster;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String Runtime) {
        this.Runtime = Runtime;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String Plot) {
        this.Plot = Plot;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }

    @NonNull
    @Override
    public String toString() {
        return "PeliculaApiResponse{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Country='" + Country + '\'' +
                ", Director='" + Director + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }
}
