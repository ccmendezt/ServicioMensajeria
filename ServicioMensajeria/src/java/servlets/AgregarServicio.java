/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.CaException;
import datos.ServicioDAO;
import negocio.Servicio;

/**
 *
 * @author CRISTIAN CAMILO
 */
@WebServlet(name = "AgregarServicio", urlPatterns = {"/AgregarServicio"})
public class AgregarServicio extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        int idCiudad = (Integer) sesion.getAttribute("idCiudad");
        Long usuario = (Long) sesion.getAttribute("passCli");
        String tipoDocUser = (String) sesion.getAttribute("tipoDocCli");
        String fInicio = (String) sesion.getAttribute("fInicio");
        String fHoraInicio = (String) sesion.getAttribute("fHoraInicio");
        String tipoServicio = (String) sesion.getAttribute("tipoServicio");
        String medioPago = (String) sesion.getAttribute("medioPago");
        String volumenPaquete = (String) sesion.getAttribute("volumenPaquete");
        int nroDir = (Integer) sesion.getAttribute("nroDir");
        float costo = (float) sesion.getAttribute("costoServicio");
        String i_tipoSer = "", i_medioPago = "";
        if(tipoServicio.equals("ida")){
            i_tipoSer = "I";
        }else{
            i_tipoSer = "V";
        }
        if(medioPago.equals("efectivo")){
            i_medioPago = "E";
        }else{
            i_medioPago = "P";
        }
        
        java.util.Date utilDate = new java.util.Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
        
        ServicioDAO servicioDAO = new ServicioDAO();
        Servicio servicio = new Servicio(idCiudad, tipoDocUser, usuario, volumenPaquete, fInicio, fHoraInicio, i_tipoSer, i_medioPago, costo);
        servicioDAO.programarServicio(servicio);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet asd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Id ciudad Servicio " + idCiudad + "</h2>");
            out.println("<h2>Tipo usuario " + tipoDocUser + "</h2>");
            out.println("<h2>Doc user " + usuario + "</h2>");
            out.println("<h2>Tipo de servicio " + i_tipoSer + "</h2>");
            out.println("<h2>Fecha inicial " + fInicio + "</h2>");
            out.println("<h2>Hora inicial" + fHoraInicio + "</h2>");
            out.println("<h2>Volumen Paquete" + volumenPaquete + "</h2>");
            out.println("<h2>Medio de pago " + i_medioPago + "</h2>");
            out.println("<h2>El costo del servicio es " + costo + "</h2>");
            
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(AgregarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AgregarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
