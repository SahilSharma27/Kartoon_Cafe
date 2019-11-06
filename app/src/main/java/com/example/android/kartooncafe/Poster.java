package com.example.android.kartooncafe;

public class Poster {
    int PosterBackDrop;
    String Title;

    public Poster(int posterBackDrop, String title) {
        PosterBackDrop = posterBackDrop;
        Title = title;
    }

    public int getPosterBackDrop() {
        return PosterBackDrop;
    }

    public void setPosterBackDrop(int posterBackDrop) {
        PosterBackDrop = posterBackDrop;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
