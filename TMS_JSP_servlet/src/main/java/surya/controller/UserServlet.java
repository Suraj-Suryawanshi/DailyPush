package surya.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import surya.model.User;
import surya.service.UserService;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService=new UserService();
    User user = new User();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin/userList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addUser(request, response);
                    break;
                case "edit":
                    editUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
            }
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setRole(request.getParameter("role"));
        user.setUserName(request.getParameter("userName"));
        user.setUserEmail(request.getParameter("userEmail"));
        user.setUserDob(request.getParameter("userDob"));
        user.setUserAddress(request.getParameter("userAddress"));
        user.setPassword(request.getParameter("password"));

        userService.addUser(user);
        response.sendRedirect("UserServlet");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
//        User user = null;

        // Find the user with the given userId
        List<User> userList = userService.getAllUsers();
        for (User u : userList) {
            if (u.getUserId() == userId) {
                user = u;
                break;
            }
        }

        if (user != null) {
            // Update user details
            user.setRole(request.getParameter("role"));
            user.setUserName(request.getParameter("userName"));
            user.setUserEmail(request.getParameter("userEmail"));
            user.setUserDob(request.getParameter("userDob"));
            user.setUserAddress(request.getParameter("userAddress"));
            user.setPassword(request.getParameter("password"));

            // Update user in the userService
            userService.updateUser(user);
        }

        response.sendRedirect("UserServlet");
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.deleteUser(userId);
        response.sendRedirect("UserServlet");
    }
}
