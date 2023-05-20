package DB;

import java.sql.*;

public class DBConnect {
    String url =  "jdbc:mysql://18.141.10.250:3306/money";

    String user = "root";
    String password = "12345";

    Connection connection;
    static DBConnect ins;
    private  DBConnect(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  DBConnect getInstance(){
        if(ins == null) ins = new DBConnect();
        return  ins;

    }
    public Statement get(){
        if(connection == null) return  null;
        try {
            return  connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
