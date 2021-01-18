/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudianteparalelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import model.controler.estudiante.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("adicionarmatricula.htm")
public class AdicionarMatriculaControler {
    
    /*
    @RequestMapping(value="/{username}", method= RequestMethod.GET)
    public String showProfilePathVar(@PathVariable("username") String user, Model model){
	model.addAttribute("username", user);
	return "userProfile";
    }	
    */
   
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView matricularestudiante(@RequestParam("ci") int ci) throws ParseException
    {   //try {
        ModelAndView mav = new ModelAndView("adicionarmatricula");
        
        Matricula m = new Matricula();
        
        Estudiante est = new Estudiante();
        est.setCi(ci);
        m.setEstudiante(est);
        
        mav.addObject("matricula", m);
        
        
        return mav;
    }

    /*@RequestMapping(method=RequestMethod.GET) 
    public ModelAndView matricularestudiante(HttpServletRequest request)
    {
       
        this.setCi(Integer.parseInt(request.getParameter("ci")));
        matricula ma = null;
        paralelo pa = null;
        estudiante es = null;
         try {
             
        System.out.println("ci:"+request.getParameter("ci"));
        int ci =Integer.parseInt( request.getParameter("ci"));
        
        ma = matriculaDAO.getMatriculaByORMID(pa, es);
        } catch (PersistentException ex) {
            Logger.getLogger(ListEstudianteControler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       ModelAndView mav=new ModelAndView();
       mav.setViewName("matricularestudiante");
        //mav.addObject("estudiante",new estudiante(es.getCi(),es.getRude(),es.getNombre(),es.getAp(),es.getAm(),
        //        es.getCorreo(),es.getTelefono(),es.getUsuario(),es.getContrasena(),es.getSuspendido(),es.getDireccion(),es.getImagen()));           
        mav.addObject("estudiante",es);
        return mav;
       
    } */
    
    /**
	 * 
	 * @param request
	 * @param es
	 */
	@RequestMapping(method=RequestMethod.POST)
	public org.springframework.web.servlet.ModelAndView matricularestudiante(HttpServletRequest request,@ModelAttribute("matricula")
	Matricula ma) {
            System.out.println("Entro aqui");
           System.out.println("ci:"+request.getParameter("estudianteId")+" "+
                    "  paralelo:"+request.getParameter("paraleloId")+ "  fecha:"+ma.getFecha());
        Estudiante es = new Estudiante();
        es.setCi(Integer.parseInt(request.getParameter("estudianteId")));   
        ma.setEstudiante(es);
        ma.setFecha(ma.getFecha());
        Paralelo pa = new Paralelo();
        pa.setIdparalelo(request.getParameter("paraleloId"));
        ma.setParalelo(pa);
        try {
            model.pojo.MatriculaDAO.save(ma);
        } catch (PersistentException ex) {
            Logger.getLogger(AdicionarMatriculaControler.class.getName()).log(Level.SEVERE, null, ex);
        }
           return new ModelAndView("redirect:listarmatriculaParaleloEstudiantes.htm");

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
         for (int i=1;i<modelpojoparalelos.length;i++) {
            Paralelo par = modelpojoparalelos[i];
           
            listadoP.put(par.getIdparalelo(),par.getNombre());
         }    
            return listadoP;
        }
        /*
        @ModelAttribute("estudianteId")
        public String lestudianteci(HttpServletRequest request){
            System.out.println("valor de cii:"+request.getParameter("ci"));
            return request.getParameter("ci");
        }*/
                
}
