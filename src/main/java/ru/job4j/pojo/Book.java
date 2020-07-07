package ru.job4j.pojo;

public class Book {
    private String name;
    private int pagesQuantity;

    public Book(String name, int pagesQuantity) {
        this.name = name;
        this.pagesQuantity = pagesQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesQuantity() {
        return pagesQuantity;
    }

    public void setPagesQuantity(int pagesQuantity) {
        this.pagesQuantity = pagesQuantity;
    }
}
