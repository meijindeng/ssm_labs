package com.dmj.dao;

import com.dmj.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增
    int addBook(Books books);
    //删
    int deleteBookById(@Param("bookId") int id);
    //改
    int updateBook(Books books);
    //查
    Books queryBookById(@Param("bookId") int id);
    //查询所有
    List<Books> queryAllBook();

    //查询书籍名称
    Books queryBookByName(@Param("bookName") String bookName);
}
