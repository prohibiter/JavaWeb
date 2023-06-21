package com.spring.dao;

import com.spring.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into book values(?,?)";
        int update = jdbcTemplate.update(sql, book.getBookId(), book.getName());
        System.out.println(update);
    }


    public void batchAdd(List<Object[]> books){
        String sql = "insert into book values(?,?)";
        int[] res = jdbcTemplate.batchUpdate(sql, books);
        for (int re :
                res) {
            System.out.println(re);
        }
    }
}
