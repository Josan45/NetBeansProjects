<%-- 
    Document   : cargarMunicipios_JSON
    Created on : 25-ene-2020, 17:33:52
    Author     : Jose Antonio
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost/andalucia";
            
            String id=request.getParameter("id");
            
            Connection con=null;
            
            try{
                
                Class.forName(driver);
                con=DriverManager.getConnection(url,"root","");
                String sql="SELECT * FROM municipios where codprov='"+id+"'";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                String codigo="";
                String nombre="";
                
                int cont=0;
                
                out.print("[");
                
                while(rs.next()){
                    codigo=rs.getString("codprov");
                    nombre=rs.getString("nombre");
                    
                    if(cont==0){
                        out.print("{codigo:'"+codigo+"',"
                            + "nombre:'"+nombre+"'}");
                    }else{
                        out.print(",{codigo:'"+codigo+"',"
                            + "nombre:'"+nombre+"'}");
                    }
                    cont++;
                }
                
                out.print("]");
                
            }catch(ClassNotFoundException e){
                
            }
%>