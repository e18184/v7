/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudianteparalelo;

import model.controler.estudiante.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import taller1.V_estudiante_matricula;
import taller1.V_estudiante_matriculaDAO;

public class ListarEstudianteParaleloControler {
    @RequestMapping("listarmatriculaParaleloEstudiantes.htm")
    public ModelAndView listarmatriculaParaleloEstudiantes() {
       
        ModelAndView mav = new ModelAndView();
       /* model.pojo.Estudiante[] modelpojoestudiantes;*/
         V_estudiante_matricula[] modelpojoestudiantes;
        try {
            /*modelpojoestudiantes = model.pojo.EstudianteDAO.listEstudianteByQuery(null, null);
              mav.addObject("datos",modelpojoestudiantes);
       mav.setViewName("listarmatriculaParaleloEstudiantes");
       */
            modelpojoestudiantes = taller1.V_estudiante_matriculaDAO.listV_estudiante_matriculaByQuery(null,"nombre,ap,am ASC");
            mav.addObject("datos",modelpojoestudiantes);
             mav.setViewName("listarmatriculaParaleloEstudiantes");
        } catch (PersistentException ex) {
            Logger.getLogger(ListarEstudianteParaleloControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mav;    
    }
            
}
