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
public class Consulta extends HttpServlet {

    public static ArrayList<Libro> listita = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta</title>");
            out.println("<style>");
            out.println("body{background-color:#ccffcc; margin-left:10px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Consulta de titulos disponibles:</h1>");
            out.println("SELECCIONA UN LIBRO");
            out.println("<form method='POST' action='resultConsulta.jsp'>");
            out.println("<select name='libro'>");
            listita = DbConnection.consultaTitulos();
            for (int x = 0; x < listita.size(); x++) {
                out.println("<option value=\"" + x + "\">" + listita.get(x).getTitulo() + "</option>");
            }
            out.println("</select>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("<button><a href='index.html'>Volver</a></button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
