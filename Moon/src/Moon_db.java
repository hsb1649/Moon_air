
/**
 * Created by Administrator on 2016-11-03.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Moon_db {
        String driver        = "org.mariadb.jdbc.Driver";
        //String url           = "jdbc:mariadb://103.218.162.26:3306/employees";
        String url           = "jdbc:mariadb://localhost:3307/univ";
        String uId           = "root";
        String uPwd          = "Eshowras1";

        Connection               con;
        PreparedStatement        pstmt;
        Statement        stmt;
        ResultSet                rs;

        public Moon_db() {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, uId, uPwd);

                if( con != null ){ System.out.println("데이터 베이스 접속 성공"); }

            } catch (ClassNotFoundException e) { System.out.println("드라이버 로드 실패");    }
            catch (SQLException e) { System.out.println("데이터 베이스 접속 실패"); }
        }


    public void createTable(){
        String  sqlC = "CREATE TABLE student2(s_number int(11), SS_number varchar(14), sex varchar(2), mobile varchar(11))";
        String  sqlD = "DROP TABLE student2";
        try {
            int i;
            stmt                = con.createStatement();
            i = stmt.executeUpdate(sqlD);
            System.out.println("Drop Table 쿼리 수행 " + i);
            i = stmt.executeUpdate(sqlC);
            System.out.println("Create Table 쿼리 수행 " + i);
            stmt.close();
        } catch (SQLException e) { System.out.println("crateTable 쿼리 수행 실패"); }
    }

    public void insertData(){
        String  sql = "INSERT  INTO  student2  (s_number, SS_number, sex, mobile) ";
        sql = sql + "VALUES  (2016045001, '070725-1234567', '남', '0101231234')";
        System.out.println("쿼리 수행" + sql);
        try {
            stmt                = con.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println("Insert 쿼리 수행" + i);
            stmt.close();
        } catch (SQLException e) { System.out.println("Insert 쿼리 수행 실패"); }
    }

    public void updateData(){
        String  sql = "UPDATE student2 SET s_number=2013555555";
        //System.out.println("쿼리 수행" + sql);
        try {
            stmt                = con.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println("Update 쿼리 수행" + i);
            stmt.close();
        } catch (SQLException e) { System.out.println("update 쿼리 수행 실패"); }
    }

    public void deleteData(){
        String  sql = "DELETE from student2 where s_number=2013555555";
        //System.out.println("쿼리 수행" + sql);
        try {
            stmt                = con.createStatement();
            int i = stmt.executeUpdate(sql);
            System.out.println("Delete 쿼리 수행" + i);
            stmt.close();
        } catch (SQLException e) { System.out.println("Delete 쿼리 수행 실패"); }
    }

    public void select(){
        String sql    = "select s_number, SS_number, sex, mobile from student2";
        System.out.println(sql);
        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("s_number")+"\t\t");
                System.out.print(rs.getString("SS_number")+"\t\t");
                System.out.print(rs.getString("sex")+"\t\t");
                System.out.println(rs.getString("mobile")+"\t\t");
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("select 쿼리 수행 실패"); }
    }


    public void select1(){ //이전 SQL 문이다
            String sql    = "select emp_no, first_name, last_name from employees where emp_no < 10010";
            try {
                pstmt                = con.prepareStatement(sql);
                rs                   = pstmt.executeQuery();
                System.out.println("emp_no\t\tfirst_name\t\tlast_name");
                while(rs.next()){
                    System.out.print(rs.getInt("emp_no")+"\t\t");
                    System.out.print(rs.getString("first_name")+"\t\t\t");
                    System.out.println(rs.getString("last_name")+"\t\t");
                }
                pstmt.close();
            } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
    }
   }
 