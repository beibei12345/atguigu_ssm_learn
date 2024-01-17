package com.atguigu.ioc.ioc02;

public class SimpleMovieLister {
    private MovieFinder movieFinder;

    private String movieName;

    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "SimpleMovieLister{" +
                "movieFinder=" + movieFinder +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
