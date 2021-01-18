/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.profesor;

import model.pojo.ProfesorCurso.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import model.pojo.extend.listaEstudiante;

public class ListProfesorCursoControler {
    @RequestMapping("listaProfesorCurso.htm")
    public ModelAndView listaProfesores() {
        ModelAndView mav = new ModelAndView();
       //java.util.List modelpojoestudiantes = null;
       model.pojo.Profesor[] modelPojoProfesorCurso; 
        try {
              modelPojoProfesorCurso = model.pojo.ProfesorCursoDAO.listProfesorCursoByQuery("estado=TRUE","nombre DESC");
              
//modelpojoestudiantes = model.pojo.extend.listaEstudiante.listarEstudianteDAO();
            mav.addObject("datos",modelPojoProfesorCurso);
       mav.setViewName("listaProfesorCurso");
       
        } catch (PersistentException ex) {
            Logger.getLogger(ListProfesorCursoControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mav;    
    }
            
}
