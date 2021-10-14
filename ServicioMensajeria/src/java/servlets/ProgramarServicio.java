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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Servicio;
import negocio.Ciudad;
import negocio.TipoPaquete;
import util.CaException;

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
            throws ServletException, IOException, CaException {

        HttpSession sesion = request.getSession();

        Object usuario = (String) sesion.getAttribute("userCli");
        Object tipoDocUser = (String) sesion.getAttribute("tipoDocCli");

        String StrCiudad = null, diaForm, horaForm, tipoServForm, medioPagoForm, volPaqForm;
        int ciudadForm, nroDirForm;

        ciudadForm = Integer.parseInt(request.getParameter("ciudad"));
        if(ciudadForm == 11001){
            StrCiudad = "Bogota";
        }else{
            if(ciudadForm == 15001){
                StrCiudad = "Tunja";
            }
        }  
        
        diaForm = request.getParameter("fInicio");
        horaForm = request.getParameter("fHoraInicio");
        tipoServForm = request.getParameter("tipoServicio");
        medioPagoForm = request.getParameter("medioPago");
        volPaqForm = request.getParameter("volumenPaquete");
        nroDirForm = Integer.parseInt(request.getParameter("nroDir"));
        String direcciones[] = new String[nroDirForm];
        String indicaciones[] = new String[nroDirForm];
        String dir = "direccion";
        String com = "comentario";
        int temp = 0;
        for (int i = 0; i < nroDirForm; i++) {
            temp = i+1;
            dir = dir + String.valueOf(temp);
            com = com + String.valueOf(temp);
            direcciones[i] = request.getParameter(dir);
            indicaciones[i] = request.getParameter(com);
            dir = "direccion";
            com = "comentario";
        }

        CiudadDAO ciudadDAO = new CiudadDAO();
        Ciudad ciudad = new Ciudad();
        TipoPaqueteDAO tpDAO = new TipoPaqueteDAO();
        TipoPaquete tp = new TipoPaquete();
        ciudad = ciudadDAO.buscarCiudad(ciudadForm);
        tp = tpDAO.buscarTipoP(volPaqForm);
        
        //  Costo Ida: (nroDir-1)*(precioTrayectoCiudad + Precio Paquete)
        //  Costo Ida y Vuelta: (nroDir)*(precioTrayectoCiudad + Precio Paquete)
        

        float costo = 0;
        if (tipoServForm.equals("ida")) {
            costo = (nroDirForm - 1) * (ciudad.getPrecioTrayecto() + tp.getTarifaPaquete());
        } else {
            if (tipoServForm.equals("vuelta")) {
                costo = (nroDirForm) * (ciudad.getPrecioTrayecto() + tp.getTarifaPaquete());
            }
        }

        sesion.setAttribute("idCiudad", ciudadForm);
        sesion.setAttribute("ciudadServicio", StrCiudad);
        sesion.setAttribute("fInicio", diaForm);
        sesion.setAttribute("fHoraInicio", horaForm);
        sesion.setAttribute("tipoServicio", tipoServForm);
        sesion.setAttribute("medioPago", medioPagoForm);
        sesion.setAttribute("volumenPaquete", volPaqForm);
        sesion.setAttribute("nroDir", nroDirForm);
        sesion.setAttribute("costoServicio", costo);
        dir = "direccion";
        com = "comentario";
        temp = 0;
        for (int i = 0; i < nroDirForm; i++) {
            temp = i+1;
            dir = dir + String.valueOf(temp);
            com = com + String.valueOf(temp);
            sesion.setAttribute(dir, direcciones[i]);
            sesion.setAttribute(com, indicaciones[i]);
            dir = "direccion";
            com = "comentario";
        }
        
        response.sendRedirect("PreFacturaServicio.jsp");
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
            Logger.getLogger(ProgramarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProgramarServicio.class.getName()).log(Level.SEVERE, null, ex);
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
