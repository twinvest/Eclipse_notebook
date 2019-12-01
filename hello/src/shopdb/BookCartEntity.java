
package shopdb;

public class BookCartEntity extends CartEntity
{
    private String isbn;
    private String title;
    private int price;
    private int quantity;
    private int sum;
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    
    public int getSum() {
        return this.sum;
    }
    
    public void setSum(final int sum) {
        this.sum = sum;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }
}