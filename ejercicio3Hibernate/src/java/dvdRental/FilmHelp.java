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
    
    public List<Customer>consultaCliente4(int id,int tramo){
        List<Customer>lista;
        
        Query q=session.createQuery("from Customer as c where c.store.storeId="+id).setFirstResult(tramo).setMaxResults(10);
        lista=(List<Customer>)q.list();
        
        return lista;
    }
    
    public long consultaPago(String cliente,int tienda){
        
        Query q=session.createQuery("select sum(p.amount) from Payment as p where p.customer.customerId="+cliente+" and p.staff="+tienda+"");
        long lista=(long)q.list().get(0);
        
        return lista;
    }
    
    public List<Inventory>consultaInventario(int id,int tramo){
        List<Inventory>lista;
        
        Query q=session.createQuery("select distinct f.title from Inventory as i,Film as f,Store as s where i.film=f.filmId and i.store=s.storeId and i.store="+id+"").setFirstResult(tramo).setMaxResults(10);
        lista=(List<Inventory>)q.list();
        
        return lista;
    }
    
    public short consultaPelisId(String title){

        Query q=session.createQuery("select f.filmId from Film as f where f.title='"+title+"'");
        short lista=(short)q.list().get(0);
        
        return lista;
    }
    
    public List<Inventory>consultaVeces(int tienda, String peli){
        List<Inventory>lista;
        
        Query q=session.createQuery("select count(r.inventory.film) from Rental r,Inventory i where r.inventory=i.inventoryId and i.store=r.staff and r.staff="+tienda+" and i.film.title='"+peli+"'");
        lista=(List<Inventory>)q.list();
        
        return lista;
    }
    
    public List<Film>consultaPelis(){
        List<Film>lista;
        
        Query q=session.createQuery("from Film as f");
        lista=(List<Film>)q.list();
        
        return lista;
    }
    
    public List<Film>consultaPelisActores(int id){
        List<Film>lista;
        
        Query q=session.createQuery("from Film as f where f.filmId="+id+"");
        lista=(List<Film>)q.list();
        
        return lista;
    }
}