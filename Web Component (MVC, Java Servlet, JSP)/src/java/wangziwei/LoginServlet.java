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
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import wangziwei.UserDAOProxy;  
import wangziwei.User;  
/** 
 * Servlet implementation class LoginServlet 
 */  
@WebServlet("/LoginServlet")  
public class LoginServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;        
    /** 
     * @see HttpServlet#HttpServlet() 
     */  
    public LoginServlet() {  
        super();  
        // TODO Auto-generated constructor stub  
    }  
  
    /** 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    String name=request.getParameter("name");  
    String password=request.getParameter("password");  
    List<String> info=new ArrayList<String>();  
    if(name==null||"".equals(name)){ 
        info.add("Username cannot be null!");  
        System.out.println("Username cannot be null!");  
    }  
  
    if(password==null||"".equals(password)){
        info.add("Password cannot be null!");  
        System.out.println("Password cannot be null");  
    }  
    if(info.size()==0){  
        User user=new User();  
        user.setName(name);  
        user.setPassword(password);  
        UserDAOProxy userDAOProxy=new UserDAOProxy();  
        try {  
              
            if(userDAOProxy.findLogin(user)){  
                  request.getRequestDispatcher("success.jsp").forward(request,response);
            }else {  
                request.getRequestDispatcher("fail.jsp").forward(request,response);
            }                         
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    request.setAttribute("info", info);
    request.getRequestDispatcher("login.jsp").forward(request,response);
      
    }  
  
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
      doGet(request, response);  
    }  
  
}  