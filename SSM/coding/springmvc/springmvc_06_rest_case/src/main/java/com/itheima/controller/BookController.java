package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    //保存
    @PostMapping
    public String save(@RequestBody Book book){

        System.out.println("book save =>"+book);

        System.out.println("book save...");


        return "{'module':'book save success'}";
    }



    //获取全部
    @GetMapping
    public List<Book> getAll(){
        System.out.println("book getAll is ok");

        List<Book> bookList = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setName("王军");
        book1.setType("傻逼");
        book1.setId(1);
        book1.setDescription("大傻逼王军");

        bookList.add(book1);

        return bookList;
    }
}














