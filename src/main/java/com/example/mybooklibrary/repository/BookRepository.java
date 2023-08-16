package com.example.mybooklibrary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mybooklibrary.domain.Book;

@Repository
public class BookRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final static RowMapper<Book> BOOK_ROW_MAPPER = (rs, i) -> {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublicationDate(rs.getDate("publication_date"));
        book.setPrice(rs.getInt("price"));
        book.setGenre(rs.getString("genre"));
        book.setRating(rs.getInt("rating"));
        book.setImpression(rs.getString("impression"));
        return book;
    };

    /**
     * 書籍を全件取得
     * @return 書籍全件
     */
    public List<Book> findAll() {
        String sql =
                """
                Select
                    id, title, author, publisher, publication_date, price, genre, rating, impression
                FROM
                    books
                """;
        List<Book> bookList = template.query(sql, BOOK_ROW_MAPPER);
        return bookList;
    }
}
