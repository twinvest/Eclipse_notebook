
package shopdb;

public class CartEntity
{
    private String uid;
    private String isbn;
    private int quantity;
    
    public String getUid() {
        return this.uid;
    }
    
    public void setUid(final String uid) {
        this.uid = uid;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}