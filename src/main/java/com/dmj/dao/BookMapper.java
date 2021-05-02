package com.dmj.dao;

import com.dmj.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加书籍
    int addBook(Books books);
    //删删除
    int deleteBookById(@Param("bookId") int id);
    //更改书籍
    int updateBook(Books books);
    //根据id查询书籍
    Books queryBookById(@Param("bookId") int id);
    //查询所有书籍
    List<Books> queryAllBook();
    //查询书籍名称
    Books queryBookByName(@Param("bookName") String bookName);
}
