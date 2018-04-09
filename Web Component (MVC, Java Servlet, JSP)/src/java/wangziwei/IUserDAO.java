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
import wangziwei.User;  
public interface IUserDAO {  

public boolean findLogin(User user) throws Exception;  
  
}  