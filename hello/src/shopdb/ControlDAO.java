package shopdb;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class ControlDAO
{
    private static final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shopdb?useUnicode=true&characterEncoding=euckr";
    private static final String USER = "root";
    private static final String PASSWD = "de52ch1683";
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public ControlDAO() {
        this.con = null;
        this.pstmt = null;
        this.rs = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void connect() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb?useUnicode=true&characterEncoding=euckr", "root", "de52ch1683");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.pstmt != null) {
                this.pstmt.close();
            }
            if (this.con != null) {
                this.con.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public BookEntity getBook(final String isbn) {
        this.connect();
        final String SQL = "select * from Book where isbn = ?";
        final BookEntity book = new BookEntity();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, isbn);
            (this.rs = this.pstmt.executeQuery()).next();
            book.setIsbn(this.rs.getString("isbn"));
            book.setTitle(this.rs.getString("title"));
            book.setAuthor(this.rs.getString("author"));
            book.setPublisher(this.rs.getString("publisher"));
            book.setPrice(this.rs.getInt("price"));
            book.setCategory(this.rs.getString("category"));
            book.setRemaining(this.rs.getInt("remaining"));
            book.setRegdate(this.rs.getDate("regdate"));
            book.setImg(this.rs.getString("img"));
            book.setDescription(this.rs.getString("description"));
        }
        catch (SQLException e) {
            e.printStackTrace();
            return book;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return book;
    }
    
    public ArrayList<BookEntity> getBookList(final String CATEGORY, final int startRecord, final int pageRecordNo) {
        this.connect();
        final ArrayList<BookEntity> list = new ArrayList<BookEntity>();
        final String sql = "select * from Book where Category = ? order by regdate desc limit ? , ? ";
        System.out.println(sql);
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, CATEGORY);
            this.pstmt.setInt(2, startRecord);
            this.pstmt.setInt(3, pageRecordNo);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final BookEntity book = new BookEntity();
                book.setIsbn(this.rs.getString("isbn"));
                book.setTitle(this.rs.getString("title"));
                book.setAuthor(this.rs.getString("author"));
                book.setPublisher(this.rs.getString("publisher"));
                book.setPrice(this.rs.getInt("price"));
                book.setCategory(this.rs.getString("category"));
                book.setRemaining(this.rs.getInt("remaining"));
                book.setRegdate(this.rs.getDate("regdate"));
                book.setImg(this.rs.getString("img"));
                book.setDescription(this.rs.getString("description"));
                list.add(book);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return list;
    }
    
    public boolean insertBook(final BookEntity entity) {
        final boolean success = false;
        this.connect();
        final String SQL = "insert into Book values (?, ?, ?, ?, ?, ?, ?, sysdate(), ?, ?)";
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, entity.getIsbn());
            this.pstmt.setString(2, entity.getTitle());
            this.pstmt.setString(3, entity.getAuthor());
            this.pstmt.setString(4, entity.getPublisher());
            this.pstmt.setInt(5, entity.getPrice());
            this.pstmt.setString(6, entity.getCategory());
            this.pstmt.setInt(7, entity.getRemaining());
            this.pstmt.setString(8, entity.getImg());
            this.pstmt.setString(9, entity.getDescription());
            this.pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return success;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return success;
    }
    
    public int getTotalRecNo(final String CATEGORY) {
        int totalRecNum = 0;
        this.connect();
        final String sql = "select count(*) as cnt from Book where category = ?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, CATEGORY);
            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                totalRecNum = this.rs.getInt("cnt");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return totalRecNum;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return totalRecNum;
    }
    
    public ArrayList<CategoryEntity> getBoardList() {
        this.connect();
        final ArrayList<CategoryEntity> list = new ArrayList<CategoryEntity>();
        final String SQL = "select * from Category ";
        try {
            this.pstmt = this.con.prepareStatement(SQL);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final CategoryEntity brd = new CategoryEntity();
                brd.setCateg(this.rs.getString("categ"));
                list.add(brd);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return list;
    }
    
    public MemberEntity getMember(final String id) {
        this.connect();
        final String SQL = "select * from Member where id = ?";
        final MemberEntity member = new MemberEntity();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, id);
            (this.rs = this.pstmt.executeQuery()).next();
            member.setId(this.rs.getString("id"));
            member.setName(this.rs.getString("name"));
            member.setAnum(this.rs.getString("anum"));
        }
        catch (SQLException e) {
            e.printStackTrace();
            return member;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return member;
    }
    
    public int getOrderNum() {
        int num = 0;
        this.connect();
        final String sql = "select max(num) as tnum from `Order`";
        try {
            this.pstmt = this.con.prepareStatement(sql);
            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                num = this.rs.getInt("tnum") + 1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return num;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return num;
    }
    
    public boolean insertOrderinfo(final int num, final String orderer, final String isbn, final Date date, final int quantity) {
        boolean success = false;
        this.connect();
        final String sql = "insert into `Order` values (?, ?, ?, ?, ?)";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, num);
            this.pstmt.setString(2, orderer);
            this.pstmt.setString(3, isbn);
            this.pstmt.setTimestamp(4, new Timestamp(date.getTime()));
            this.pstmt.setInt(5, quantity);
            final int retval = this.pstmt.executeUpdate();
            if (retval > 0) {
                success = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return success;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return success;
    }
    
    public ArrayList<OrderBookEntity> getOrderList(final String orderer) {
        this.connect();
        final String SQL = "select date(buydate) as buydate, num, B.title, sum(B.price *A.quantity) as total, count(*) as cnt  from `Order` A, Book B where orderer=? and  date(buydate)  >= date(subdate(now(), interval 3 month)) and A.isbn = B.isbn group by num order by num desc ";
        final ArrayList<OrderBookEntity> list = new ArrayList<OrderBookEntity>();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, orderer);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final OrderBookEntity entity = new OrderBookEntity();
                entity.setBuydate((Date)this.rs.getDate("buydate"));
                entity.setNum(this.rs.getInt("num"));
                entity.setTitle(this.rs.getString("title"));
                entity.setTotal(this.rs.getInt("total"));
                entity.setCnt(this.rs.getInt("cnt"));
                list.add(entity);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return list;
    }
    
    public boolean insertCart(final String uid, final String isbn, final int quantity) {
        boolean success = false;
        this.connect();
        final String sql = "insert into Cart values (?, ?, ?)";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, uid);
            this.pstmt.setString(2, isbn);
            this.pstmt.setInt(3, quantity);
            final int retval = this.pstmt.executeUpdate();
            if (retval > 0) {
                success = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return success;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return success;
    }
    
    public boolean deleteCart(final String uid, final String isbn) {
        boolean success = false;
        this.connect();
        final String sql = "delete from Cart where uid = ? and isbn = ?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, uid);
            this.pstmt.setString(2, isbn);
            final int retval = this.pstmt.executeUpdate();
            if (retval > 0) {
                success = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return success;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return success;
    }
    
    public ArrayList<BookCartEntity> getCart(final String uid) {
        this.connect();
        final String SQL = "select A.isbn, B.title, B.price, sum(A.quantity) as quantity, (B.price * sum(A.quantity)) as sum from Cart A, Book B where uid=? and A.isbn = B.isbn group by A.isbn";
        final ArrayList<BookCartEntity> list = new ArrayList<BookCartEntity>();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, uid);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final BookCartEntity entity = new BookCartEntity();
                entity.setIsbn(this.rs.getString("isbn"));
                entity.setTitle(this.rs.getString("title"));
                entity.setPrice(this.rs.getInt("price"));
                entity.setQuantity(this.rs.getInt("quantity"));
                entity.setSum(this.rs.getInt("sum"));
                list.add(entity);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return list;
    }
}