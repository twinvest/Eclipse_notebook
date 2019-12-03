
package shopdb;

import java.util.Date;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class BangDAO
{
    private static final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shopdb?useUnicode=true&characterEncoding=euckr";
    private static final String USER = "root";
    private static final String PASSWD = "gksdideo1!";
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public BangDAO() {
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
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb?useUnicode=true&characterEncoding=euckr", "root", "gksdideo1!");
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
    
    public ArrayList<BangEntity> getBangList() {
        this.connect();
        final ArrayList<BangEntity> list = new ArrayList<BangEntity>();
        final String SQL = "select * from Bang order by ref desc, step";
        try {
            this.pstmt = this.con.prepareStatement(SQL);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final BangEntity brd = new BangEntity();
                brd.setNum(this.rs.getInt("num"));
                brd.setName(this.rs.getString("name"));
                brd.setPasswd(this.rs.getString("passwd"));
                brd.setTitle(this.rs.getString("title"));
                brd.setRegdate((Date)this.rs.getTimestamp("regdate"));
                brd.setContent(this.rs.getString("content"));
                brd.setHit(this.rs.getInt("hit"));
                brd.setRef(this.rs.getInt("ref"));
                brd.setStep(this.rs.getInt("step"));
                brd.setDepth(this.rs.getInt("depth"));
                brd.setChildCount(this.rs.getInt("childCount"));
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
    
    public BangEntity getBang(final int num) {
        this.connect();
        final String SQL = "select * from Bang where num = ?";
        final BangEntity brd = new BangEntity();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setInt(1, num);
            (this.rs = this.pstmt.executeQuery()).next();
            brd.setNum(this.rs.getInt("num"));
            brd.setName(this.rs.getString("name"));
            brd.setPasswd(this.rs.getString("passwd"));
            brd.setTitle(this.rs.getString("title"));
            brd.setRegdate((Date)this.rs.getTimestamp("regdate"));
            brd.setContent(this.rs.getString("content"));
            brd.setHit(this.rs.getInt("hit"));
            brd.setRef(this.rs.getInt("ref"));
            brd.setStep(this.rs.getInt("step"));
            brd.setDepth(this.rs.getInt("depth"));
            brd.setChildCount(this.rs.getInt("childCount"));
        }
        catch (SQLException e) {
            e.printStackTrace();
            return brd;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        return brd;
    }
    
    public boolean insertDB(final BangEntity board) {
        boolean success = false;
        this.connect();
        String sql = "select max(num) as maxnum from Bang";
        try {
            this.pstmt = this.con.prepareStatement(sql);
            (this.rs = this.pstmt.executeQuery()).next();
            final int maxnum = this.rs.getInt("maxnum") + 1;
            sql = "insert into Bang values(?, ?, ?, ?, sysdate(), ?, 0, ?, 0, 0, 0)";
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, maxnum);
            this.pstmt.setString(2, board.getName());
            this.pstmt.setString(3, board.getPasswd());
            this.pstmt.setString(4, board.getTitle());
            this.pstmt.setString(5, board.getContent());
            this.pstmt.setInt(6, maxnum);
            this.pstmt.executeUpdate();
            success = true;
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
    
    public boolean updateDB(final BangEntity bang) {
        boolean success = false;
        this.connect();
        final String sql = "update Bang set name=?, title=?, content=? where num=?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, bang.getName());
            this.pstmt.setString(2, bang.getTitle());
            this.pstmt.setString(3, bang.getContent());
            this.pstmt.setInt(4, bang.getNum());
            final int rowUdt = this.pstmt.executeUpdate();
            if (rowUdt == 1) {
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
    
    public boolean insertReply(final BangEntity board) {
        boolean success = false;
        int num = 0;
        int step = 0;
        this.connect();
        try {
            String sql = "select min(step) as tstep from Bang where ref = ? and step > ? and depth <= ?";
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, board.getRef());
            this.pstmt.setInt(2, board.getStep());
            this.pstmt.setInt(3, board.getDepth());
            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                step = this.rs.getInt("tstep");
            }
            if (step > 0) {
                step = this.rs.getInt("tstep");
                sql = "update Bang set step = step + 1 where ref = ? and step >= ? ";
                (this.pstmt = this.con.prepareStatement(sql)).setInt(1, board.getRef());
                this.pstmt.setInt(2, step);
                this.pstmt.executeUpdate();
            }
            else {
                sql = "select max(step) as tstep from Bang where ref = ? ";
                (this.pstmt = this.con.prepareStatement(sql)).setInt(1, board.getRef());
                this.rs = this.pstmt.executeQuery();
                if (this.rs.next()) {
                    step = this.rs.getInt("tstep") + 1;
                }
            }
            sql = "select max(num) as tnum from Bang";
            this.pstmt = this.con.prepareStatement(sql);
            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                num = this.rs.getInt("tnum") + 1;
            }
            final int depth = board.getDepth() + 1;
            sql = "insert into Bang values(?, ?, ?, ?, sysdate(), ?, 0, ?, ?, ?, 0)";
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, num);
            this.pstmt.setString(2, board.getName());
            this.pstmt.setString(3, board.getPasswd());
            this.pstmt.setString(4, board.getTitle());
            this.pstmt.setString(5, board.getContent());
            this.pstmt.setInt(6, board.getRef());
            this.pstmt.setInt(7, step);
            this.pstmt.setInt(8, depth);
            this.pstmt.executeUpdate();
            for (int r = depth - 1; r >= 0; --r) {
                sql = "select max(step) as tstep from Bang where ref = ? and depth = ? and step < ?";
                (this.pstmt = this.con.prepareStatement(sql)).setInt(1, board.getRef());
                this.pstmt.setInt(2, r);
                this.pstmt.setInt(3, step);
                this.rs = this.pstmt.executeQuery();
                int maxstep = 0;
                if (this.rs.next()) {
                    maxstep = this.rs.getInt("tstep");
                }
                sql = "update Bang set childCount = childCount + 1  where ref = ? and depth = ? and step = ? ";
                (this.pstmt = this.con.prepareStatement(sql)).setInt(1, board.getRef());
                this.pstmt.setInt(2, r);
                this.pstmt.setInt(3, maxstep);
                this.pstmt.executeUpdate();
            }
            success = true;
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
    
    public boolean isPasswd(final int num, final String passwd) {
        boolean success = false;
        this.connect();
        final String sql = "select passwd from Bang where num=?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, num);
            (this.rs = this.pstmt.executeQuery()).next();
            final String orgPasswd = this.rs.getString(1);
            if (passwd.equals(orgPasswd)) {
                success = true;
            }
            System.out.println(success);
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
    
    public boolean updateHit(final int num, final int hit) {
        boolean success = false;
        this.connect();
        final String sql = "update Bang set hit=? where num=?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, hit);
            this.pstmt.setInt(2, num);
            final int rowUdt = this.pstmt.executeUpdate();
            if (rowUdt == 1) {
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
    
    public int deleteDB(final int num) {
        int retval = 0;
        this.connect();
        try {
            String sql = "select * from Bang where num = ?";
            (this.pstmt = this.con.prepareStatement(sql)).setInt(1, num);
            (this.rs = this.pstmt.executeQuery()).next();
            final int ref = this.rs.getInt("ref");
            final int step = this.rs.getInt("step");
            final int depth = this.rs.getInt("depth");
            final int childCount = this.rs.getInt("childCount");
            if (childCount == 0) {
                sql = "delete from Bang where num = ? ";
                (this.pstmt = this.con.prepareStatement(sql)).setInt(1, num);
                final int i = this.pstmt.executeUpdate();
                if (i > 0) {
                    retval = 0;
                }
                for (int r = depth - 1; r >= 0; --r) {
                    sql = "select max(step) as tstep from Bang where ref=? and depth=? and step < ? ";
                    (this.pstmt = this.con.prepareStatement(sql)).setInt(1, ref);
                    this.pstmt.setInt(2, r);
                    this.pstmt.setInt(3, step);
                    (this.rs = this.pstmt.executeQuery()).next();
                    final int maxstep = this.rs.getInt("tstep");
                    sql = "update Bang set childCount = childCount - 1 where ref = ? and depth = ? and step = ? ";
                    (this.pstmt = this.con.prepareStatement(sql)).setInt(1, ref);
                    this.pstmt.setInt(2, r);
                    this.pstmt.setInt(3, maxstep);
                    this.pstmt.executeUpdate();
                }
            }
            else {
                retval = 1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return retval;
        }
        finally {
            this.disconnect();
        }
        this.disconnect();
        System.out.println("retval " + retval);
        return retval;
    }
    
    public ArrayList<BangEntity> getBangList(final int startRecord, final int pageRecordNo) {
        this.connect();
        final ArrayList<BangEntity> list = new ArrayList<BangEntity>();
        final String sql = "select * from Bang order by ref desc, step limit " + startRecord + ", " + pageRecordNo;
        System.out.println(sql);
        try {
            this.pstmt = this.con.prepareStatement(sql);
            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                final BangEntity brd = new BangEntity();
                brd.setNum(this.rs.getInt("num"));
                brd.setName(this.rs.getString("name"));
                brd.setPasswd(this.rs.getString("passwd"));
                brd.setTitle(this.rs.getString("title"));
                brd.setRegdate((Date)this.rs.getTimestamp("regdate"));
                brd.setContent(this.rs.getString("content"));
                brd.setHit(this.rs.getInt("hit"));
                brd.setRef(this.rs.getInt("ref"));
                brd.setStep(this.rs.getInt("step"));
                brd.setDepth(this.rs.getInt("depth"));
                brd.setChildCount(this.rs.getInt("childCount"));
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
    
    public int getTotalRecNo() {
        int totalRecNum = 0;
        this.connect();
        final String sql = "select count(*) as cnt from Bang";
        try {
            this.pstmt = this.con.prepareStatement(sql);
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
}