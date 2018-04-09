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
import wangziwei.IUserDAO;  
import wangziwei.UserDAOImpI;  
import wangziwei.DatabaseConnection;  
import wangziwei.User;  
public class UserDAOProxy implements IUserDAO{  
    private DatabaseConnection dbc=null;
    private IUserDAO dao=null;
    public UserDAOProxy(){  
        try {  
            dbc=new DatabaseConnection();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        dao=new UserDAOImpI(dbc.getConnection());  
          
    }  
    @Override  
    public boolean findLogin(User user) throws Exception {  
        boolean flag=false;  
        try {  
            flag=dao.findLogin(user);
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }  
        return flag;  
    }  
  
}  