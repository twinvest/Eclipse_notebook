package shopdb;

import java.util.Date;

public class BookEntity
{
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String category;
    private int remaining;
    private Date regdate;
    private String img;
    private String description;
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(final String author) {
        this.author = author;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
    }
    
    public int getRemaining() {
        return this.remaining;
    }
    
    public void setRemaining(final int remaining) {
        this.remaining = remaining;
    }
    
    public Date getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(final Date regdate) {
        this.regdate = regdate;
    }
    
    public String getImg() {
        return this.img;
    }
    
    public void setImg(final String img) {
        this.img = img;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
}