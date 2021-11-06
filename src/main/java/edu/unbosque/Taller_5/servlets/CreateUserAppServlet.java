package edu.unbosque.Taller_5.servlets;

import edu.unbosque.Taller_5.services.UserAppService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createUserAppServlet", value = "/create-user")
public class CreateUserAppServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        UserAppService userappService = new UserAppService();
        userappService.saveUserApp(username, password, email, role);

        response.sendRedirect("./index.jsp");
    }

}
