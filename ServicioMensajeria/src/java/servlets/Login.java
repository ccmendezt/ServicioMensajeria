/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import datos.ClienteDAO;
import datos.MensajeroDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Cliente;
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
            throws ServletException, IOException, CaException {

        String user, tipoUsuario;
        long pass;
        tipoUsuario = request.getParameter("tipoUsuario");
        user = request.getParameter("user");
        pass = Long.parseLong(request.getParameter("pass"));

        if (tipoUsuario.equals("cli")) {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente c;
            c = clienteDAO.iniciarSesion(user, pass);

            if (c == null) {
                request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
                request.getRequestDispatcher("InicioSesionIncorrecto.html").forward(request, response);
            } else {
                response.sendRedirect("InicioSesionCliente.jsp");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("tipoDocCli", c.getTipoDoc());
                sesion.setAttribute("userCli", c.getEmail());
                sesion.setAttribute("passCli", c.getNroDoc());
            }
        } else {
            if (tipoUsuario.equals("men")) {

                MensajeroDAO mensajeroDAO = new MensajeroDAO();
                Mensajero m;
                m = mensajeroDAO.iniciarSesion(user, pass);

                if (m == null) {
                    request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
                    request.getRequestDispatcher("InicioSesionIncorrecto.html").forward(request, response);
                } else {
                    response.sendRedirect("InicioSesionMensajero.jsp");
                }

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
        try {
            processRequest(request, response);
        } catch (CaException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (CaException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
