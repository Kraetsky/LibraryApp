package com.example.demo.services;


import com.example.demo.domain.Book;
import com.example.demo.security.CurrentUser;
import com.example.demo.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kraet on 16.05.2017.
 */
@Service
public class BookService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Book add(Book book) {

        int id = SecurityUtils.getCurrentUser().getId();
        String isTakenBy=jdbcTemplate.queryForObject("select name from users where id=?",String.class,id);
        book.setIsTakenBy(isTakenBy);
        jdbcTemplate.update("insert into books (author,ISN,title,userId,isTakenBy) VALUES(?,?,?,?,?)", book.getAuthor(), book.getIsn(), book.getTitle(), id,book.getIsTakenBy());
        book.setUserId(id);
        return book;
    }

    public void delete(Book book) {
        jdbcTemplate.update("delete from books where ISN = ?", book.getIsn());
    }

    public Book update(Book book) {
        int id = SecurityUtils.getCurrentUser().getId();
        String isTakenBy=jdbcTemplate.queryForObject("select name from users where id=?",String.class,id);
        book.setIsTakenBy(isTakenBy);
        jdbcTemplate.update("update books set author=? ,title=? , userId=?, isTakenBy=? where ISN = ?", book.getAuthor(), book.getTitle()
                , id , book.getIsTakenBy(),book.getIsn());
        return book;
    }

    public List<Book> list() {
        String sql = "SELECT * FROM books";
        List<Book> listBook = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book aBook = new Book();

                aBook.setUserId(rs.getInt("userId"));
                aBook.setTitle(rs.getString("title"));
                aBook.setAuthor(rs.getString("author"));
                aBook.setIsn(rs.getInt("ISN"));
                aBook.setIsTakenBy(rs.getString("isTakenBy"));


                return aBook;
            }
        });

        return listBook;
    }
}
