package com.vti.entity.inheritance.ques4;

// tạp chí
public class Magazine extends Document {
    private int releaseNumber;
    private int monthRelease;

    public Magazine(int id, String publishingCompany, int numberOfReleases, int releaseNumber, int monthReleaseNumber) {
        super(id, publishingCompany, numberOfReleases);
        this.releaseNumber = releaseNumber;
        this.monthRelease = monthReleaseNumber;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public int getMonthRelease() {
        return monthRelease;
    }

    public void setMonthRelease(int monthRelease) {
        this.monthRelease = monthRelease;
    }

    @Override
    public String toString() {
        return "Magazine{ id = " + getId() + ", " +
                "releaseNumber=" + releaseNumber +
                ", monthRelease=" + monthRelease +
                '}';
    }
}
