package com.example.mybooklibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybooklibrary.domain.Book;
import com.example.mybooklibrary.repository.BookRepository;

@Service
@Transactional
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    /**
     * 書籍を全件取得
     * @return 書籍全件
     */
    public List<Book> showList() {
        return bookRepository.findAll();
    }

    /**
     * 書籍を登録
     * @param book 書籍情報
     */
    public void register(Book book) {
        bookRepository.insert(book);
    }

    /**
     * IDに一致する書籍を削除
     * @param id 書籍ID
     */
    public void delete(int id) {
        bookRepository.delete(id);
    }
}
