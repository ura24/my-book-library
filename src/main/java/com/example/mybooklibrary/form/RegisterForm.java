package com.example.mybooklibrary.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class RegisterForm {
    /** タイトル */
    @NotBlank(message = "タイトルを入力してください")
    private String title;
    /** 著者 */
    @NotBlank(message = "著者を入力してください")
    private String author;
    /** 出版社 */
    @NotBlank(message = "出版社を入力してください")
    private String publisher;
    /** 出版日 */
    @NotBlank(message = "出版日を入力してください")
    private String publicationDate;
    /** 値段 */
    @NotBlank(message = "値段を入力してください")
    private String price;
    /** ジャンル */
    @Length(min = 1, message = "ジャンルを選択してください")
    private String genre;
    /** 評価 */
    private String rating;
    /** 感想 */
    private String impression;
    
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
    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getImpression() {
        return impression;
    }
    public void setImpression(String impression) {
        this.impression = impression;
    }

    @Override
    public String toString() {
        return "RegisterForm [title=" + title + ", author=" + author + ", publisher=" + publisher + ", publicationDate="
                + publicationDate + ", price=" + price + ", genre=" + genre + ", rating=" + rating + ", impression="
                + impression + "]";
    }

}
