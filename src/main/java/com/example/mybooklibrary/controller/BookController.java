package com.example.mybooklibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mybooklibrary.domain.Book;
import com.example.mybooklibrary.service.BookService;

@Controller
@RequestMapping("")
public class BookController {

    @Autowired
    private BookService bookService;
    
    /**
     * 一覧画面を表示
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<Book> bookList = bookService.showList();
        model.addAttribute("bookList", bookList);
        return "list.html";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register.html";
    }

    @PostMapping("/delete")
    public String delete(int id) {
        bookService.delete(id);
        return "redirect:";
    }

}
