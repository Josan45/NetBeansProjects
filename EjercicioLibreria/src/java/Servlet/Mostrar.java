/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.DbConnection;
import Modelo.Libro;
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
public class Mostrar extends HttpServlet {

    public static ArrayList<Libro>listit=new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mostrar tabla</title>");
            out.println("<style>");
            out.println("table{border-color:red;margin-left:10px; margin-top:10px;}");
            out.println("body{background-color:#ccffcc;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='2px' solid>");
            out.println("<tr style='background-color:yellow; font-weight:bold;'><td>Código</td><td>Título</td><td>Autor</td><td>Fecha</td><td>Página</td><td>Precio</td></tr>");
            listit=DbConnection.consultaTitulos();
            for(int x=0;x<listit.size();x++){
                out.println("<tr>");
                out.println("<td>"+listit.get(x).getCodigo()+"</td>");
                out.println("<td>"+listit.get(x).getTitulo()+"</td>");  
                out.println("<td>"+listit.get(x).getAutor()+"</td>");
                out.println("<td>"+listit.get(x).getFecha()+"</td>");
                out.println("<td>"+listit.get(x).getPaginas()+"</td>");
                out.println("<td>"+listit.get(x).getPrecio()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<button style='margin-left:10px;'><a href='index.html'>Volver a la página principal</a></button>");
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
