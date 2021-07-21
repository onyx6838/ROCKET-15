package com.vti.entity.inheritance.ques4;

public class Document {
    private int id;
    private String publishingCompany;
    private int numberOfReleases;   // số bản phát hành

    public Document(int id, String publishingCompany, int numberOfReleases) {
        this.id = id;
        this.publishingCompany = publishingCompany;
        this.numberOfReleases = numberOfReleases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getNumberOfReleases() {
        return numberOfReleases;
    }

    public void setNumberOfReleases(int numberOfReleases) {
        this.numberOfReleases = numberOfReleases;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", publishingCompany='" + publishingCompany + '\'' +
                ", numberOfReleases=" + numberOfReleases +
                '}';
    }
}
