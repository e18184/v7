/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo.extend;

import java.util.List;
import org.hibernate.Query;
import org.orm.*;
import model.pojo.Estudiante;
/**
 *
 * @author richards
 */
public class listaMatriculagetCi{
    private PersistentSession  sesion;
     public listaMatriculagetCi() throws PersistentException
    {
        //System.out.println("prueba");
        obtenNombres();
    }

    public static void main(String[] args) throws PersistentException 
    {
        new listaMatriculagetCi();
    }
     private void iniciaOperacion() throws PersistentException
    {
        sesion = model.pojo.ProyectoPersistentManager.instance().getSession();
    }

    private void terminaOperacion() throws PersistentException
    {
        sesion.getTransaction().commit();
        sesion.close();
    }

    private void obtenNombres() throws PersistentException
    {
        iniciaOperacion();

        Query query = sesion.createQuery("FROM model.pojo.Estudiante as m");

        List<Estudiante> listaResultados = query.list();

        for (int i = 0; i < listaResultados.size(); i++)
        {
            System.out.println("Nombre " + i + ": " + listaResultados.get(i));
        }

        terminaOperacion();
    }
    
}
