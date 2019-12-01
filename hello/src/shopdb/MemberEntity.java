package shopdb;

public class MemberEntity
{
    private String id;
    private String passwd;
    private String name;
    private String jnum;
    private String cnum;
    private String anum;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getPasswd() {
        return this.passwd;
    }
    
    public void setPasswd(final String passwd) {
        this.passwd = passwd;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getJnum() {
        return this.jnum;
    }
    
    public void setJnum(final String jnum) {
        this.jnum = jnum;
    }
    
    public String getCnum() {
        return this.cnum;
    }
    
    public void setCnum(final String cnum) {
        this.cnum = cnum;
    }
    
    public String getAnum() {
        return this.anum;
    }
    
    public void setAnum(final String anum) {
        this.anum = anum;
    }
}