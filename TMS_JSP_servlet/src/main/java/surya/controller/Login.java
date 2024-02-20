package surya.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import surya.model.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int pKey = 1;
    
    /**sdfsdfsdfssdf
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String roleId = request.getParameter("roleId");
		String password =request.getParameter("password");
		System.out.println(email+roleId+password);
		ArrayList<User> db = new ArrayList<>();
		User obj2 = new User(pKey++,"admin","Shiva","shiva@gmail.com","01/03/2001","ABC residency","password");
		User obj1 = new User(pKey++,"employee","Surya","surya@gmail.com","01/03/2005","XYZ residency","password");
		User obj3 = new User(pKey++,"manager","Rocky","rocky@gmail.com","01/03/2002","ajk residency","password");
		db.add(obj1);
		db.add(obj2);
		db.add(obj3);
//		System.out.println(db);
//		int x=obj1.getRollId();
//		int a=Integer.parseInt(roleId);
//		System.out.println("Rollid"+a);
		
		for(User singleObj:db) {
//			System.out.println(db);
			System.out.println("\n{{{{{{------}}}}}"+singleObj.getPassword()+singleObj.getRole()+singleObj.getUserEmail()+"\n");
			if(singleObj.getUserEmail().equals(email) && singleObj.getPassword().equals(password) && singleObj.getRole().equals(roleId)) {
				
				if("admin".equals(roleId)) {
//				    String page = "admin/admin1.jsp";
				    System.out.println("admin--------------");
    
				    response.sendRedirect("admin/admin1.jsp");
					System.out.println("101---");
					return;
										
				}
				else if("manager".equals(roleId)) {
//				    String page = "manager/manager.jsp";
//				    String page = "";
//				    try {
//				    } catch (Exception e) {
//				      page = "error.jsp";
//				    }
				    response.sendRedirect("manager/manager.jsp");
				    System.out.println("manager--------------");				    
					System.out.println("102---");
					return;
					
				}
				else {
//				    String page = "employee.jsp";
				    System.out.println("manager--------------");
				    response.sendRedirect("employee/employeeDisp.jsp");
				    return;
					
				}
				

			}	

		}
		System.out.println("something went wrong...");
		response.sendRedirect("index.jsp?error=1");
		return;
	}

}
