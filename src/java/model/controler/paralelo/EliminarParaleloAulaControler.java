/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.paralelo;
import java.text.DateFormat;
import model.controler.estudianteparalelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import model.controler.estudiante.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Asigna;
import model.pojo.Aula;
import model.pojo.Matricula;
import model.pojo.MatriculaDAO;
import model.pojo.Paralelo;
import model.pojo.ParaleloDAO;
import model.pojo.Estudiante;
import model.pojo.EstudianteDAO;
import static model.pojo.EstudianteDAO.getEstudianteByORMID;
import static model.pojo.MatriculaDAO.getMatriculaByORMID;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("eliminarparaleloaula.htm")
public class EliminarParaleloAulaControler {
    
    /*
    @RequestMapping(value="/{username}", method= RequestMethod.GET)
    public String showProfilePathVar(@PathVariable("username") String user, Model model){
	model.addAttribute("username", user);
	return "userProfile";
    }	
    */
   
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView matricularestudiante(@RequestParam("idparalelo") String idparalelo) throws ParseException
    {   //try {
        ModelAndView mav = new ModelAndView("adicionarparaleloaula");
        
        Asigna a = new Asigna();
        
        Paralelo par = new Paralelo();
        System.out.println("idparalelo:"+idparalelo);
        par.setIdparalelo(idparalelo);
        a.setParalelo(par);
        //devuelve la fecha de un año
        Date date = new Date();
       DateFormat format = new SimpleDateFormat("yyyy");
       String year = format.format(date);
       a.setAnno(year);

        //a.getParalelo().getIdparalelo()
        mav.addObject("asigna", a);
        
        
        return mav;
    }
}
