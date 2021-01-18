/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.paralelo;

import model.controler.estudiante.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;


public class ListarParaleloAulaControler {
     @RequestMapping("listarParaleloAula.htm")
    
    public ModelAndView listarParaleloAula() {
        ModelAndView mav = new ModelAndView();
       model.pojo.Paralelo[] modelpojoparalelos;
        try {
            modelpojoparalelos = model.pojo.ParaleloDAO.listParaleloByQuery(null, null);
              mav.addObject("datos",modelpojoparalelos);
       mav.setViewName("listarParaleloAula");
       
        } catch (PersistentException ex) {
            Logger.getLogger(ListarParaleloAulaControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mav;    
    }
            
}
