package firstpro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/index1")
public class index1 extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		
		try {
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String str1="select * from students";
			Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college","root","123456");
			PreparedStatement ps=cn.prepareStatement(str1);
			ResultSet rs=ps.executeQuery();
			boolean ref=true;
			while(rs.next()) {
				String c_username=rs.getString(1);
				String c_password=rs.getString(2);
				String name=rs.getString(3);
				int age=rs.getInt(4);
				int marks=rs.getInt(5);
				int avg=rs.getInt(6);
				Cookie ck=new Cookie("name",username);
				ck.setMaxAge(60*60);
				res.addCookie(ck);
				
				
				
			
				if(username.equals(c_username)&&password.equals(c_password)){
					PrintWriter pw;
					try {
						pw = res.getWriter();
						pw.println("name:"+name);
						pw.println("age:"+age);
						pw.println("marks:"+marks);
						pw.println("avg:"+avg);
						
						ref=false;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ps.execute();
					cn.close();
				
				}
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
		
			
		
	


		
	

