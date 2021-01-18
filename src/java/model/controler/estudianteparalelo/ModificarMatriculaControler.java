/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudianteparalelo;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pojo.Estudiante;
import model.pojo.Matricula;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.pojo.MateriaDAO;
import model.pojo.Paralelo;
import org.orm.PersistentException;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author richards
 */
@Controller
@RequestMapping("adicionarmatricula.htm")
public class ModificarMatriculaControler {

@RequestMapping(method = RequestMethod.GET)
    public ModelAndView matricularestudiante(@RequestParam("ci") int ci) throws ParseException, PersistentException
    {  // try {
        //try {
        List lista = model.pojo.MatriculaDAO.queryMatricula("estudianteci="+ci+" and fecha=(select max(fecha) "
               + "from Matricula where estudianteci="+ci +") ","estudianteci");
        ModelAndView mav = new ModelAndView("modificarmatricula");
        if (lista.get(0)!=null) {
        Matricula m = (Matricula)lista.get(0);
        
        Estudiante est = new Estudiante();
        est.setCi(ci);
        m.setEstudiante(est);
        
        //m.getParalelo().getIdparalelo()
        //m.getParaleloId()
        //m.getParalelo().getIdparalelo();
        //m.getParalelo().getNombre()
        mav.addObject("matricula", m);
        }
        
        
        
        return mav;
        /* List lista = model.pojo.matriculaDAO.queryMatricula("model.pojo.matricula.estudianteId=2","ASC");
        for (Iterator it = lista.iterator(); it.hasNext();) {
            matricula b = (matricula)it.next();
            System.out.println("est:"+b.getEstudiante().getCi()+" paralelo: "+b.getParalelo().getNombre());  
        }
        
    } catch (PersistentException ex) {
        Logger.getLogger(ModificarMatriculaControler.class.getName()).log(Level.SEVERE, null, ex);
    }*/
    }    
    @ModelAttribute("paraleloId")
        public Map<String,String> listadoparalelos() {
            model.pojo.Paralelo[] modelpojoparalelos;
            modelpojoparalelos = null;
        try {
           modelpojoparalelos = model.pojo.ParaleloDAO.listParaleloByQuery(null,null);
        } catch (PersistentException ex) {
            Logger.getLogger(MatricularEstudianteParaleloControler1.class.getName()).log(Level.SEVERE, null, ex);
        }
            Map <String,String> listadoP = new LinkedHashMap<>();
         for (int i=0;i<modelpojoparalelos.length;i++) {
            Paralelo par = modelpojoparalelos[i];
           
            listadoP.put(par.getIdparalelo(),par.getNombre());
         }    
            return listadoP;
        }
}
