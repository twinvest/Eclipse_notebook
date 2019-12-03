
package shopdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class MemberDAO
{
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shopdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; // localhost:3306 포트는 컴퓨터설치된 mysql주소
    private String USER;
    private static final String PASSWD = "gksdideo1!";
    private Connection con;
    private PreparedStatement pstmt;
    
   
    public MemberDAO() {
        this.USER = "root";
        this.con = null;
        this.pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void connect() {
        try {
            this.con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect() {
        try {
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
    
    public boolean insertDB(final MemberEntity member) {
        
    	boolean success = false;
        this.connect();
        if(con == null)
    		System.out.println("con이 널!");
        //System.out.println("성공!!");
        final String sql = "insert into mem(id, passwd, name, jnum, cnum, anum) values(?, ?, ?, ?, ?, ? )";
        try {
        	pstmt = con.prepareStatement(sql);
            this.pstmt.setString(1, member.getId());
            this.pstmt.setString(2, member.getPasswd());
            this.pstmt.setString(3, member.getName());
            this.pstmt.setString(4, member.getJnum());
            this.pstmt.setString(5, member.getCnum());
            this.pstmt.setString(6, member.getAnum());
            final int rows = this.pstmt.executeUpdate();
            if (rows == 1) {
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
    
    public boolean isPasswd(final String id, final String passwd) {
        boolean success = false;
        this.connect();
        final String sql = "select passwd from Mem where id=?";
        try {
            (this.pstmt = this.con.prepareStatement(sql)).setString(1, id);
            final ResultSet rs = this.pstmt.executeQuery();
            rs.next();
            final String orgPasswd = rs.getString(1);
            if (passwd.equals(orgPasswd)) {
                success = true;
            }
            rs.close();
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
    
    public MemberEntity getMember(final String id) {
        this.connect();
        final String SQL = "select * from Mem where id = ?";
        final MemberEntity member = new MemberEntity();
        try {
            (this.pstmt = this.con.prepareStatement(SQL)).setString(1, id);
            final ResultSet rs = this.pstmt.executeQuery();
            rs.next();
            member.setId(rs.getString("id"));
            member.setPasswd(rs.getString("passwd"));
            member.setName(rs.getString("name"));
            member.setJnum(rs.getString("jnum"));
            member.setCnum(rs.getString("cnum"));
            member.setAnum(rs.getString("anum"));
            rs.close();
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
}