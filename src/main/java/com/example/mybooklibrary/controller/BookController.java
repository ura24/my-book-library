package com.example.mybooklibrary.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mybooklibrary.domain.Book;
import com.example.mybooklibrary.form.RegisterForm;
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
    public String toRegister(RegisterForm registerForm, Model model) {
        List<String> genreList = new ArrayList<>(Arrays.asList(
                                    "",
                                    "文学・評論", 
                                    "ノンフィクション",
                                    "ビジネス・経済",
                                    "歴史・地理",
                                    "政治・社会",
                                    "芸能・エンターテイメント",
                                    "アート・建築・デザイン",
                                    "人文・思想・宗教",
                                    "暮らし・健康・料理",
                                    "コンピュータ・IT",
                                    "自然科学",
                                    "趣味・応用",
                                    "教育・自己啓発",
                                    "辞典・年鑑・本・ことば",
                                    "音楽",
                                    "旅行・紀行",
                                    "絵本・児童書",
                                    "コミックス"));
        model.addAttribute("genreList", genreList);

        return "register.html";
    }

    @PostMapping("/register")
    public String register(@Validated RegisterForm registerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("ああああああああ");
            System.out.println(registerForm);
            return toRegister(registerForm, model);
        }

        Book book = new Book(
                        registerForm.getTitle(), 
                        registerForm.getAuthor(), 
                        registerForm.getPublisher(), 
                        Date.valueOf(registerForm.getPublicationDate()), 
                        Integer.valueOf(registerForm.getPrice()), 
                        registerForm.getGenre(), 
                        Integer.valueOf(registerForm.getRating()),
                        registerForm.getImpression()
                    ); 
                    
        bookService.register(book);
        return "redirect:/";

    }

    @PostMapping("/delete")
    public String delete(int id) {
        bookService.delete(id);
        return "redirect:";
    }

}
