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

/**
 * Servlet implementation class first
 */
@WebServlet("/first")
public class first extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		
		try {
			String str1="insert into employee5 values(?,?,?,?,?,?)";
			Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vsb","root","123456");
			PreparedStatement ps=cn.prepareStatement(str1);
			ps.setInt(1,Integer.parseInt(req.getParameter("id")));
			ps.setString(2,req.getParameter("name"));
			ps.setInt(3,Integer.parseInt(req.getParameter("salary")));
			ps.setInt(4,Integer.parseInt(req.getParameter("age")));
			ps.setString(5,req.getParameter("gender"));
			ps.setString(6,req.getParameter("d_o_j"));
			 ps.execute();
			try {
				PrintWriter pw=res.getWriter();
				pw.print("inserted succesfully");
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
