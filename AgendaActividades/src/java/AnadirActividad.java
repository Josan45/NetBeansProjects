
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnadirActividad extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String lug=request.getParameter("lug");
        String fec=request.getParameter("fec");
        String hor=request.getParameter("hor");
        String dest=request.getParameter("dest");
        String oc=request.getParameter("oc");
        String texto=request.getParameter("texto");
        
    public actividades(String nom, String lug, String fec, String hor, String dest, String oc, String texto) {
        this.setNombre(nom);
        this.setLug(lug);
        this.setFecha(fec);
        this.setEmail(email);
        this.setAsunto(hor);
        this.setPrioridad(prioridad);
        this.setTelefono(telefono);
    }

    public String getNombre() {
        return nom;
    }

    public void setNombre(String nom) {
        this.nom = nom;
    }

    public String geLug() {
        return lug;
    }

    public void setLug(String lug) {
        this.lug = lug;
    }

    public String getFec() {
        return fec;
    }

    public void setFecha(String fec) {
        this.fec = fec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}