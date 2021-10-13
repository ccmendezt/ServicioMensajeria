/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.ServicioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import util.CaException;

/**
 *
 * @author CRISTIAN CAMILO
 */
@WebServlet(name = "ConsultarServicio", urlPatterns = {"/ConsultarServicio"})
public class ConsultarServicio extends HttpServlet {

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
            throws ServletException, IOException, CaException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        int opcion = 0, idServicio = 0;
        long nroDocCli = 0;
        String fechaServicio = "", tipoDocCli = "";
        ServicioDAO servDAO = new ServicioDAO();
        ResultSet rs = null;
        String id = "";
        opcion = Integer.parseInt(request.getParameter("tipoConsultaS"));
        
            idServicio = Integer.parseInt(request.getParameter("idServicio"));
            rs = servDAO.buscarServicioById(idServicio);
            sesion.setAttribute("consultaServicio", rs);
            id = rs.getString(1);
        /*if(opcion == 1){
        }else{
            if(opcion == 2){
                fechaServicio = request.getParameter("fInicio");
                rs = servDAO.buscarServicioByDate(fechaServicio);
                sesion.setAttribute("consultaServicio", rs);
            }else{
                if(opcion == 3){
                    tipoDocCli = (String) sesion.getAttribute("tipoDocCli");
                    nroDocCli = Long.parseLong(request.getParameter("documentoId"));
                    rs = servDAO.buscarServicioByCliente(tipoDocCli, nroDocCli);
                    sesion.setAttribute("consultaServicio", rs);
                }
            }
        }*/
        
        
        
        
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet asd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>id servicio " + id + "</h2>");
            out.println("<h2>fecha servicio " + fechaServicio + "</h2>");
            out.println("<h2>nroDoc " + nroDocCli + "</h2>");
            out.println("</body>");
            out.println("</html>");
        //response.sendRedirect("MostrarServicio.jsp");
        
        
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
            Logger.getLogger(ConsultarServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConsultarServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
