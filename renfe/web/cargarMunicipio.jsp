<%-- 
    Document   : cargarMunicipio
    Created on : 28-ene-2020, 13:12:21
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/xml" pageEncoding="UTF-8"%>

        <%
            String origen=request.getParameter("origen");
            
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM municipios where codprov='"+origen+"';";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                String codigo="";
                String nombre="";
                
                out.print("<municipios>");
                
                while(rs.next()){
                    codigo=rs.getString("cod");
                    nombre=rs.getString("nombre");
                    out.print("<municipio>"
                            + "<codigo>"+codigo+"</codigo>"
                            + "<nombre>"+nombre+"</nombre>"
                            + "</municipio>");
                }
                out.print("</municipios>");
                
            }catch(ClassNotFoundException ex){
                
            }
            
            %>
