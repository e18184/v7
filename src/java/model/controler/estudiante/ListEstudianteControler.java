/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudiante;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import model.pojo.extend.listaEstudiante;

public class ListEstudianteControler {
    @RequestMapping("listaEstudiantes.htm")
    public ModelAndView listaEstudiantes() {
        ModelAndView mav = new ModelAndView();
       //java.util.List modelpojoestudiantes = null;
       model.pojo.Estudiante[] modelpojoestudiantes; 
        try {
              modelpojoestudiantes = model.pojo.EstudianteDAO.listEstudianteByQuery("estado=TRUE","nombre DESC");
              //modelpojoestudiantes = model.pojo.extend.listaEstudiante.listarEstudianteDAO();
            mav.addObject("datos",modelpojoestudiantes);
       mav.setViewName("listaEstudiantes");
       
        } catch (PersistentException ex) {
            Logger.getLogger(ListEstudianteControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mav;    
    }
            
}
