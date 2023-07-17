package net.javaguides.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.login.bean.LoginBean;
import net.javaguides.login.bean.Student;
import net.javaguides.login.database.LoginDao;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}
	protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException
{
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet StudentServlet</title>");
out.println("</head>");
out.println("<body>");

// List to hold Student objects
ArrayList<Student> std = new ArrayList<Student>();

// Adding members to the list. Here we are 
// using the parameterized constructor of 
// class "Student.java"
std.add(new Student(1,"Roxy Willard", 100, "B.D.S"));
std.add(new Student(2,"Todd Lanz", 35, "B.Tech"));
std.add(new Student(3,"Varlene Lade", 70, "B.B.A"));
std.add(new Student(4,"Julio Fairley", 30, "B.Tech"));
std.add(new Student(5,"Helena Carlow", 24, "M.B.B.S"));
Map<String, List<Student>> map = new HashMap<String, List<Student>>();

// put every value list to Map
for (Student s : std) {
	   List<Student> h=map.get(s.getCrs());
	   if(h!=null ) {
		   h.add(s);
	   }
	   if(h==null|| h.isEmpty()) {
		 h= new ArrayList<>();
		 h.add(s);
	   }
	   map.put(s.getCrs(), h);
   // map.computeIfAbsent(s.getCrs(), f->new ArrayList<>().add(s));
}

// Setting the attribute of the request object
// which will be later fetched by a JSP page
request.setAttribute("data", std);
request.setAttribute("datas", map);

// Creating a RequestDispatcher object to dispatch
// the request the request to another resource
RequestDispatcher rd = 
request.getRequestDispatcher("stdlist.jsp");

// The request will be forwarded to the resource 
// specified, here the resource is a JSP named,
// "stdlist.jsp"
rd.forward(request, response);
out.println("</body>");
out.println("</html>");
}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDao.validate(loginBean)) {
				//HttpSession session = request.getSession();
				// session.setAttribute("username",username);
				 processRequest(request, response);
				//response.sendRedirect("stdlist.jsp");
			} else {
				HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				//response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
