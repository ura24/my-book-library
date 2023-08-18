package com.example.mybooklibrary.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.mybooklibrary.domain.Book;

@Repository
public class BookRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Book> BOOK_ROW_MAPPER = (rs, i) -> {
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

    private final String FIND_ALL_SQL = """
            Select
                id, title, author, publisher, publication_date, price, genre, rating, impression
            FROM
                books;
            """;

    private final String INSERT_SQL = """
            INSERT INTO
                books(title, author, publisher, publication_date, price, genre, rating, impression)
            VALUES
                (:title, :author, :publisher, :publicationDate, :price, :genre, :rating, :impression)
            """;
    
    private final String DELETE_SQL = """
            DELETE FROM
                books
            WHERE
                id = :id;
            """;

    /**
     * 書籍を全件取得
     * @return 書籍全件
     */
    public List<Book> findAll() {
        List<Book> bookList = template.query(FIND_ALL_SQL, BOOK_ROW_MAPPER);
        return bookList;
    }

    public void insert(Book book) {
        SqlParameterSource param = new MapSqlParameterSource()
                                        .addValue("title", book.getTitle())
                                        .addValue("author", book.getAuthor())
                                        .addValue("publisher", book.getPublisher())
                                        .addValue("publicationDate", book.getPublicationDate())
                                        .addValue("price", book.getPrice())
                                        .addValue("genre", book.getGenre())
                                        .addValue("rating", book.getRating())
                                        .addValue("impression", book.getImpression());
        template.update(INSERT_SQL, param);
    }

    /**
     * idに一致する書籍を削除
     * @param id 書籍ID
     */
    public void delete(Integer id) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        template.update(DELETE_SQL, param);
    }
}
