package com.example.mybooklibrary.domain;

import java.sql.Date;

public class Book {
    /** ID */
    private Integer id;
    /** タイトル */
    private String title;
    /** 著者 */
    private String author;
    /** 出版社 */
    private String publisher;
    /** 出版日 */
    private Date publicationDate;
    /** 値段 */
    private Integer price;
    /** ジャンル */
    private String genre;
    /** 評価 */
    private Integer rating;
    /** 画像URL */
    private String imageUrl;
    /** 感想 */
    private String impression;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImpression() {
        return impression;
    }
    public void setImpression(String impression) {
        this.impression = impression;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
                + ", publicationDate=" + publicationDate + ", price=" + price + ", genre=" + genre + ", rating="
                + rating + ", imageUrl=" + imageUrl + ", impression=" + impression + "]";
    }
}
