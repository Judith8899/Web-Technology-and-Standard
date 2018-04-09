
package wangziwei;

/**
 *
 * @author judith8899
 */
import java.sql.Connection;  
import java.sql.DriverManager;  
public class DatabaseConnection {  
    private static final String DBDRIVER="org.apache.derby.jdbc.ClientDriver";  
    private static final String DBURL="jdbc:derby://localhost:1527/wzw";
    private static final String DBUSER="IS2560";  
    private static final String DBPASS="IS2560";  
    private Connection connection=null;  
    public DatabaseConnection() throws Exception{  
        try{  
            Class.forName(DBDRIVER);  
            connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);  
              
        }catch(Exception exception ){  
            throw exception;  
        } finally {  
        }     
    }  
    public Connection getConnection(){  
        return connection;  
    }  
    public void close() throws Exception{  
        if(connection!=null){  
            try {  
                connection.close();
            } catch (Exception e) {  
                throw e;  
            }  
        }
    }
}  