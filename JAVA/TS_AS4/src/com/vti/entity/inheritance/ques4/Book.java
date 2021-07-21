package com.vti.entity.inheritance.ques4;

public class Book extends Document {
    private String author;
    private int pageNumber;

    public Book(int id, String publishingCompany, int numberOfReleases, String author, int pageNumber) {
        super(id, publishingCompany, numberOfReleases);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Book{ id = " + getId() + ", " +
                "author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }

}
