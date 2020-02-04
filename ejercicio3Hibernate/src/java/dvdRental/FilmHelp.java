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
 * @author Jose Antonio
 */
public class FilmHelp {
    Session session;

    public FilmHelp() {
        
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        this.session = sessionFactory.getCurrentSession();
        org.hibernate.Transaction tx=session.beginTransaction();  
    }
    
    public List<Store>consultaTienda(){
        List<Store>lista;
        
        Query q=session.createQuery("from Store as s");
        lista=(List<Store>)q.list();
        
        return lista;
    }
    
    public List<Customer>consultaCliente(){
        List<Customer>lista;
        
        Query q=session.createQuery("from Customer as c");
        lista=(List<Customer>)q.list();
        
        return lista;
    }
    
    public List<Rental>consultaTienda2(int videoclub,int cliente, int tramo){
        List<Rental>lista;
        
        Query q=session.createQuery("from Rental as r where r.customer.customerId="+cliente+" "
                + "and r.staff.store.storeId="+videoclub).setFirstResult(tramo).setMaxResults(10);
        lista=(List<Rental>)q.list();
        
        return lista;
    }
    
    public List<Store>consultaTienda5(int id){
        List<Store>lista;
        
        Query q=session.createQuery("from Store as s where s.storeId="+id+"");
        lista=(List<Store>)q.list();
        
        return lista;
    }
}