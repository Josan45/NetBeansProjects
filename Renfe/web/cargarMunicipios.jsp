<%-- 
    Document   : cargarMunicipios
    Created on : 24-ene-2020, 8:50:17
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/xml" pageEncoding="UTF-8"%>

        <%
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            
            String id=request.getParameter("id");
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM municipios where codprov="+id;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                out.print("<municipios>");
                
                while(rs.next()){
                    String cod=rs.getString("cod");
                    String nombre=rs.getString("nombre");
                    out.print("<municipio>"
                            + "<codigo>"+cod+"</codigo>"
                            + "<nombre>"+nombre+"</nombre>"
                            + "</municipio>");
                }
                out.print("</municipios>");
                
            }catch(ClassNotFoundException ex){
                
            }
            
            %>