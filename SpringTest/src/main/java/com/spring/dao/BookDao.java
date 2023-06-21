package com.spring.dao;

import com.spring.bean.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);
    public void batchAdd(List<Object[]> books);
}
