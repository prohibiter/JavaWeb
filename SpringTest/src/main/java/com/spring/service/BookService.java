package com.spring.service;

import com.spring.bean.Book;
import com.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    public void batchAdd(List<Object[]> books){
        bookDao.batchAdd(books);
    }
}
