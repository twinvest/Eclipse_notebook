package shopdb;

public class OrderBookEntity extends OrderinfoEntity
{
    private String title;
    private int total;
    private int cnt;
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public int getCnt() {
        return this.cnt;
    }
    
    public void setCnt(final int cnt) {
        this.cnt = cnt;
    }
}