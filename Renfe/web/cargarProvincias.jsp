<%-- 
    Document   : cargarProvincias
    Created on : 24-ene-2020, 8:48:35
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/xml" pageEncoding="UTF-8"%>

        <%
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM provincias";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                String nombre="";
                String codpro="";
                
                while(rs.next()){
                    nombre=rs.getString("nombre");
                    codpro=rs.getString("codpro");
                    out.print("<provincias>"
                            + "<codpro>"+codpro+"</codpro>"
                            + "<nombre>"+nombre+"</nombre>"
                        + "</provincias>");
                }
                
            }catch(ClassNotFoundException ex){
                
            }
            
            %>
