package com.dmj.service;

import com.dmj.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增
    int addBook(Books books);
    //删
    int deleteBookById(int id);
    //改
    int updateBook(Books books);
    //查
    Books queryBookById(int id);
    //查询所有
    List<Books> queryAllBook();
    //查询书籍名称
    Books queryBookByName(String bookName);
}
