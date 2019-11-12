/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DbConnection;
import Modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Antonio
 */
public class Consulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo_a_buscar=request.getParameter("titulo").trim();
        int tamano=titulo_a_buscar.length();
        
        if(tamano<1){
            request.getRequestDispatcher("/erro1.html").forward(request, response);
        }else{
            request.getRequestDispatcher("/Consulta.jsp").forward(request, response);
        }
    }
}