package com.vti.entity.inheritance.ques4;

// Báo
public class Article extends Document{
    private int dayRelease;

    public Article(int id, String publishingCompany, int numberOfReleases, int dayRelease) {
        super(id, publishingCompany, numberOfReleases);
        this.dayRelease = dayRelease;
    }

    public int getDayRelease() {
        return dayRelease;
    }

    public void setDayRelease(int dayRelease) {
        this.dayRelease = dayRelease;
    }

    @Override
    public String toString() {
        return "Article{ id = " + getId() + ", " +
                "dayRelease=" + dayRelease +
                '}';
    }
}
