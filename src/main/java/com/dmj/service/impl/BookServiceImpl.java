package com.dmj.service.impl;

import com.dmj.dao.BookMapper;
import com.dmj.entity.Books;
import com.dmj.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    //sercice调dao：组合dao
    private BookMapper bookMapper;
    //set方法
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
