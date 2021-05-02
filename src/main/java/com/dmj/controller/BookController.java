package com.dmj.controller;

import com.dmj.entity.Books;
import com.dmj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调sercice
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }


    //跳转增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook==>"+books);
        bookService.addBook(books);
        //重定向到/book/allBook页面
        return "redirect:/book/allBook";
    }


    //跳转修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){//旧风格
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }
    //修改数据的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook==>"+books);
        int i = bookService.updateBook(books);
        if (i>0){
            System.out.println("添加成功"+books);
        }
        //重定向到/book/allBook页面
        return "redirect:/book/allBook";
    }


    //删除书籍的请求
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){//新风格
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if(books==null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
