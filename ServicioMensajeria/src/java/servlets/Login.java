/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import datos.MensajeroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Mensajero;
import util.CaException;

/**
 *
 * @author CRISTIAN CAMILO
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException{

        String user, tipoUsuario;
        long pass;
        tipoUsuario = request.getParameter("tipoUsuario");
        user = request.getParameter("user");
        pass = Long.parseLong(request.getParameter("password"));

        if (tipoUsuario.equals("1")) {
            System.out.println("En proceso...");
        } else {
            if (tipoUsuario.equals("2")) {
                PrintWriter out;
                out = response.getWriter();
                
                MensajeroDAO mensajeroDAO = new MensajeroDAO();
                Mensajero mensajero = new Mensajero();
                mensajero = mensajeroDAO.iniciarSesion(user, pass);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet asd</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Entro al if de mensajero</h1>");
                out.println("</body>");
                out.println("</html>");
                
                
                /*
                if (m == null) {
                    request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
                    //request.getRequestDispatcher("index.html").forward(request, response);
                } else {
                    response.sendRedirect("InicioSesionMensajero.jsp");
                }*/
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
