package com.spring.bean;

public class Book {
    private String name;
    private String bookId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    public Object[] getString() {
        Object[] book = {bookId,name};
        return book;
    }
}
