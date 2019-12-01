package shopdb;

import java.util.Date;

public class OrderinfoEntity
{
    private String orderer;
    private String isbn;
    private int num;
    private Date buydate;
    private int quantity;
    
    public String getOrderer() {
        return this.orderer;
    }
    
    public void setOrderer(final String orderer) {
        this.orderer = orderer;
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
    
    public int getNum() {
        return this.num;
    }
    
    public void setNum(final int num) {
        this.num = num;
    }
    
    public Date getBuydate() {
        return this.buydate;
    }
    
    public void setBuydate(final Date buydate) {
        this.buydate = buydate;
    }
}