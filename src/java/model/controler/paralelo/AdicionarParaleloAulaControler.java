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
@RequestMapping("adicionarparaleloaula.htm")
public class AdicionarParaleloAulaControler {
    
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
	public org.springframework.web.servlet.ModelAndView adicionarparaleloaula(HttpServletRequest request,@ModelAttribute("asigna")
	Asigna as) {
            System.out.println("Entro aqui");
           System.out.println("paraleloID:"+request.getParameter("paraleloId")+" "+
                    "  Aula:"+request.getParameter("aulaId")+ "  entrada:"+as.getHoraentrada()+"  salida: "+ as.getHorasalida()+" anno"+as.getAnno());
        Paralelo pa = new Paralelo();
        pa.setIdparalelo(request.getParameter("paraleloId"));
        as.setParalelo(pa);
        Aula a =new Aula();
        a.setIdaula(request.getParameter("aulaId"));
        as.setAula(a);
        
        try {
            model.pojo.AsignaDAO.save(as);
        } catch (PersistentException ex) {
            Logger.getLogger(AdicionarParaleloAulaControler.class.getName()).log(Level.SEVERE, null, ex);
        }
           return new ModelAndView("redirect:listarparaleloaula.htm");

	}
	
        
     
        @ModelAttribute("aulaId")
        public Map<String,String> listadoaulas() {
            model.pojo.Aula[] modelpojoaulas;
            modelpojoaulas = null;
        try {
           modelpojoaulas = model.pojo.AulaDAO.listAulaByQuery(null,null);
        } catch (PersistentException ex) {
            Logger.getLogger(MatricularEstudianteParaleloControler1.class.getName()).log(Level.SEVERE, null, ex);
        }
            Map <String,String> listadoA = new LinkedHashMap<>();
         for (int i=0;i<modelpojoaulas.length;i++) {
            Aula au = modelpojoaulas[i];
           
            listadoA.put(au.getIdaula(),au.getNombre());
         }    
         System.out.println("listado aulas:"+listadoA);
            return listadoA;
        }
        
        /*
        @ModelAttribute("estudianteId")
        public String lestudianteci(HttpServletRequest request){
            System.out.println("valor de cii:"+request.getParameter("ci"));
            return request.getParameter("ci");
        }*/
                
}
