/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdRental;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno_2DAW
 */
public class FilmHelper {
    Session session=null;
    public FilmHelper(){
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        this.session=sessionFactory.openSession();
        org.hibernate.Transaction tx=session.beginTransaction();
    }
}
