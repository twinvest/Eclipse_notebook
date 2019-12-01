package shopdb;

import java.util.Date;

public class BoardEntity
{
    private int num;
    private String name;
    private String passwd;
    private String title;
    private Date regdate;
    private String content;
    private int hit;
    private int ref;
    private int step;
    private int depth;
    private int childCount;
    
    public int getNum() {
        return this.num;
    }
    
    public void setNum(final int num) {
        this.num = num;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(final String passwd) {
        this.passwd = passwd;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public Date getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(final Date regdate) {
        this.regdate = regdate;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public int getHit() {
        return this.hit;
    }
    
    public void setHit(final int hit) {
        this.hit = hit;
    }
    
    public int getRef() {
        return this.ref;
    }
    
    public void setRef(final int ref) {
        this.ref = ref;
    }
    
    public int getStep() {
        return this.step;
    }
    
    public void setStep(final int step) {
        this.step = step;
    }
    
    public int getDepth() {
        return this.depth;
    }
    
    public void setDepth(final int depth) {
        this.depth = depth;
    }
    
    public int getChildCount() {
        return this.childCount;
    }
    
    public void setChildCount(final int childCount) {
        this.childCount = childCount;
    }
}