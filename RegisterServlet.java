
package web1;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {
    String name;
    int age;
    
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1> hi this is register Servlet</h1>");
       name=request.getParameter("user_name");
       String age2=request.getParameter("user_age");
       age = Integer.parseInt(age2);
        
       out.println("<h1>name "+ name+"</h1>");
     out.println("<h1>age "+age +"</h1>");
    
    
    
   
 try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
        Statement statement = conn.createStatement();
      
        statement.executeUpdate("insert into info values ('"+name +"' ,'"+age +"')");
         
            
       System.out.println("data of students");
        ResultSet resultSet = statement.executeQuery("select * from info");
        
        
       while(resultSet.next()){
       out.println(" <h1>" +resultSet.getString(1)+" "+resultSet.getInt(2)+"</h1>");
       }
        
        }
        catch(ClassNotFoundException | SQLException e) 
        {
            
            System.out.println("not connected");
        }
    
    
    
    
    }
}
