package sadden.wenzhai.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class ConnectMysql {

	// 驱动程序名
    public String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名test
    public String url = "jdbc:mysql://localhost:3306/test";
    // MySQL配置时的用户名
    public String user = "root"; 
    // MySQL配置时的密码
    public String password = "03011217";
    
    public ConnectMysql()
    {
    	
    }
    
}
