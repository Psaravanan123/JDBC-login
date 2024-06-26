package firstpro;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class signup extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		
		try {
			String str1="insert into students values(?,?,?,?,?,?)";
			Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","123456");
			PreparedStatement ps=cn.prepareStatement(str1);
			ps.setString(1,req.getParameter("username"));
			ps.setString(2,req.getParameter("password"));
			ps.setString(3,req.getParameter("name"));
			ps.setInt(4,Integer.parseInt(req.getParameter("age")));
			ps.setInt(5,Integer.parseInt(req.getParameter("mark")));
			ps.setInt(6,Integer.parseInt(req.getParameter("avg")));
			
			 ps.execute();
			try {
				PrintWriter pw=res.getWriter();
				pw.print("created succesfully");
				
			
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			cn.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}


}
