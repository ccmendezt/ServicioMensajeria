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
import javax.servlet.http.HttpSession;
import datos.ServicioDAO;
import datos.CiudadDAO;
import datos.TipoPaqueteDAO;
import negocio.Servicio;
import negocio.Ciudad;
import negocio.TipoPaquete;


/**
 *
 * @author CRISTIAN CAMILO
 */
@WebServlet(name = "ProgramarServicio", urlPatterns = {"/ProgramarServicio"})
public class ProgramarServicio extends HttpServlet {

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
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        Object usuario = (String) sesion.getAttribute("userCli");
        Object tipoDocUser = (String) sesion.getAttribute("tipoDocCli");
        
        ServicioDAO servDAO = new ServicioDAO();
        Servicio servicio = new Servicio();
        CiudadDAO ciudadDAO = new CiudadDAO();
        Ciudad ciudad = new Ciudad();
        TipoPaqueteDAO tpDAO = new TipoPaqueteDAO();
        TipoPaquete tp = new TipoPaquete();
        
        
        
        String diaForm, horaForm, tipoServForm, medioPagoForm, volPaqForm;
        int ciudadForm, nroDirForm;
        
        ciudadForm = Integer.parseInt(request.getParameter("ciudad"));
        diaForm = request.getParameter("fInicio");
        horaForm = request.getParameter("fHoraInicio");
        tipoServForm = request.getParameter("tipoServicio");
        medioPagoForm = request.getParameter("medioPago");
        volPaqForm = request.getParameter("volumenPaquete");
        nroDirForm = Integer.parseInt(request.getParameter("nroDir"));
        /*user = request.getParameter("user");
        pass = Long.parseLong(request.getParameter("pass"));*/
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProgramarServicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProgramarServicio at " + request.getContextPath() + "</h1>");
            out.println("<h2>Ciudad Servicio " + ciudadForm + "</h2>");
            out.println("<h2>Fecha servicio " + diaForm + "</h2>");
            out.println("<h2>Hora servicio " + horaForm + "</h2>");
            out.println("<h2>Usuario cliente " + usuario + "</h2>");
            out.println("<h2>Tipo doc cliente " + tipoDocUser + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public float costoServicio(int ciudad, String tipoServicio, String volPaquete, int nroDir){
        float costo = 0;
        
        
        
        
        return costo;
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
