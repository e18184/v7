/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package model.pojo.extend;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.*;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import model.pojo.Estudiante;
import model.pojo.Matricula;
/**
 *
 * @author richards
 */
public class listPaginateEstudianteDAO {

    public int listPaginatedEstudianteUsingQuery(int firstResult, int maxResults) {
        int paginatedCount = 0;
        try {
            PersistentSession session;
            try {
                session = model.pojo.ProyectoPersistentManager.instance().getSession();
            
            Query query = session.createQuery("From estudiante");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            List<Estudiante> estudiantes = (List<Estudiante>) query.list();
            if (estudiantes != null) {
                paginatedCount = estudiantes.size();
                System.out.println("Total Results: " + paginatedCount);
                for (Estudiante estudiante : estudiantes) {
                    System.out.println("Retrieved Product using Query. Name: " + Estudiante.class);
                }
            }
            session.close();
 
        } catch (HibernateException e) {
            e.printStackTrace();
 
        } } catch (PersistentException ex) {
                Logger.getLogger(listPaginateEstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
            
        }
        return paginatedCount;
    }
  

}
