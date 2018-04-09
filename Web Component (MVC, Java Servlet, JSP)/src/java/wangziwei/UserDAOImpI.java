/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wangziwei;

/**
 *
 * @author judith8899
 */
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import wangziwei.User;  
public class UserDAOImpI implements IUserDAO{  
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    public UserDAOImpI(Connection conn){
        this.conn=conn;  
    }  
    @Override  
    public boolean findLogin(User user) throws Exception {  
        boolean flag=false;  
        try {  
            String sql="select name from demo where name=? and password=?";  
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());  
            pstmt.setString(2, user.getPassword());  
            ResultSet rSet=pstmt.executeQuery();
            if(rSet.next()){  
                user.setName(rSet.getString(1));
                flag=true;        
            }  
  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            if(pstmt!=null){  
                try {  
                    pstmt.close();  
                } catch (Exception e) {  
                    throw e;                  
            }         
        }  
              
        }  
        return flag;  
    }  
      
}  