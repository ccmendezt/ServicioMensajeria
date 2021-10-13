/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import datos.DireccionDAO;
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
import negocio.Direccion;
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
        if (tipoServicio.equals("ida")) {
            i_tipoSer = "I";
        } else {
            i_tipoSer = "V";
        }
        if (medioPago.equals("efectivo")) {
            i_medioPago = "E";
        } else {
            i_medioPago = "P";
        }
        Object direcciones[] = new String[nroDir];
        Object indicaciones[] = new String[nroDir];
        String dir = "direccion";
        String com = "comentario";
        int temp = 0;
        for (int i = 0; i < nroDir; i++) {
            temp = i + 1;
            dir = dir + String.valueOf(temp);
            com = com + String.valueOf(temp);
            direcciones[i] = (String) sesion.getAttribute(dir);
            indicaciones[i] = (String) sesion.getAttribute(com);
            dir = "direccion";
            com = "comentario";
        }

        /*java.util.Date utilDate = new java.util.Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);*/
        ServicioDAO servicioDAO = new ServicioDAO();
        Servicio s = new Servicio(idCiudad, tipoDocUser, usuario, volumenPaquete, fInicio, fHoraInicio, i_tipoSer, i_medioPago, costo);
        servicioDAO.programarServicio(s);

        DireccionDAO dirDAO = new DireccionDAO();
        Direccion dirServicio = new Direccion();
        s = servicioDAO.buscarServicio(fInicio, fHoraInicio, volumenPaquete);
        dirServicio.setIdServicio(s.getIdServicio());
        for (int i = 0; i < nroDir; i++) {
            dirServicio.setDireccion(fInicio);
            dirServicio.setDireccion((String) direcciones[i]);
            dirServicio.setActividad((String) indicaciones[i]);
            dirDAO.programarServicio(dirServicio);
        }

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>");
        out.println("window.onload = function () {");
        out.println("alert(\"Servicio programado exitosamente\");");
        out.println("window.location.href = \"InicioSesionCliente.jsp\";");
        out.println("};");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

        //sesion.setAttribute("servicioExitoso", "true");
        //sesion.setAttribute("programarServicio", "El servicio ha sido programado con éxito");
        //response.sendRedirect("InicioSesionCliente.jsp");

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
