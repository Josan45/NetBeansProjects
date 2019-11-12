/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.Comercial;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Antonio
 */
public class ventasListado extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ventasListado</title>"); 
            out.println("<meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n" +
"        <style>\n" +
"            body{\n" +
"                background-color:#ccffcc;\n" +
"                margin-top: 5px;\n" +
"            }\n" +
"            \n" +
"            a{\n" +
"                color:black;                \n" +
"            }\n" +
"        </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<div>");
            out.println("<form method='POST' action='resultado.jsp'>");
            out.println("<button><a href='ventasListado'>Listado de Ventas</a></button>");
            out.println("<button><a href='alta.html'>Alta Venta</a></button>");
            out.println("<button><a href='modificar'>Modificar Venta</a></button><br><br>");
            
            ArrayList<Comercial>listaComercial=new ArrayList();
            
            listaComercial=Modelo.DbConnection.consultaComerciales();
            
            out.println("<select name='cod'>");
            for(int x=0;x<listaComercial.size();x++){
            out.println("<option value='"+listaComercial.get(x).getCodigo()+"'>"+listaComercial.get(x).getNombre()+"</option>");
            }
            out.println("</select>");
            out.println("<br><br>");
            out.println("<input type='submit' value='Listado de ventas'>");
            out.println("</form>");
            out.println("</center>");
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
