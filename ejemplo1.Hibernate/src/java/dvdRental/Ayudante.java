/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author José Antonio
 */
public class Ayudante {
    Session session=null;
    
    public Ayudante(){
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        this.session=sessionFactory.openSession();
        org.hibernate.Transaction tx=session.beginTransaction();
    }
    
    public List<Category> getCategoria(){
        List<Category> Categorias;
        Query q=session.createQuery("from Category as category");
        Categorias=(List<Category>) q.list();
        
        return Categorias;
    }
}
