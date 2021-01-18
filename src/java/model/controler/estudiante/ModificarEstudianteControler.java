/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudiante;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.pojo.EstudianteDAO;
import static model.pojo.EstudianteDAO.getEstudianteByORMID;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import model.pojo.*;

@Controller
@RequestMapping("modificarEstudiante.htm")
public class ModificarEstudianteControler {
    
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView modificarEstudiante(HttpServletRequest request)
    {
        Estudiante es = null;
         try {
             
        System.out.println("ci:"+request.getParameter("ci"));
        int ci =Integer.parseInt( request.getParameter("ci"));
         es = getEstudianteByORMID(ci);
        } catch (PersistentException ex) {
            Logger.getLogger(ListEstudianteControler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       ModelAndView mav=new ModelAndView();
       mav.setViewName("modificarEstudiante");
        //mav.addObject("estudiante",new estudiante(es.getCi(),es.getRude(),es.getNombre(),es.getAp(),es.getAm(),
        //        es.getCorreo(),es.getTelefono(),es.getUsuario(),es.getContrasena(),es.getSuspendido(),es.getDireccion(),es.getImagen()));           
        mav.addObject("estudiante",es);
        return mav;
       
    }
    
    /**
	 * 
	 * @param request
	 * @param es
	 */
	@RequestMapping(method=RequestMethod.POST)
	public org.springframework.web.servlet.ModelAndView modificarEstudiante(HttpServletRequest request, @ModelAttribute("estudiante")
	Estudiante es) {
            System.out.println("Entro aqui");
        
        try {
        
         System.out.println("nombre:"+es.getNombre());
          System.out.println("Apellido Paterno:"+es.getAp());
           System.out.println("Apellido Materno:"+es.getAm());
         System.out.println("direccion:"+es.getDireccion());
         es.setCi(es.getCi());
         es.setRude(es.getRude());
         es.setNombre(es.getNombre());
         es.setAp(es.getAp());
         es.setAm(es.getAm());
         es.setCorreo(es.getCorreo());
         es.setUsuario(es.getUsuario());
         es.setContrasena(es.getContrasena());
         es.setSuspendido(es.getSuspendido());
         es.setDireccion(es.getDireccion());
         es.setImagen(es.getImagen());
            EstudianteDAO.save(es);
        } catch (PersistentException ex) {
            Logger.getLogger(ModificarEstudianteControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:listaEstudiantes.htm");

	}
	
        
        @ModelAttribute("suspendidos")
        public Map<String,String> listadosuspendido()
        {
            Map <String,String> listado = new LinkedHashMap<>();
            listado.put("0","Suspendido");
            listado.put("1","No suspendido");
            return listado;
        }

	/**
	 * 
	 * @param request
	 * @param es
     * @return 
	 */
	//@RequestMapping(method=RequestMethod.POST)
	//public org.springframework.web.servlet.ModelAndView modificarEstudiante(HttpServletRequest request, @ModelAttribute("estudiante")
	//Estudiante es) {
        //return null;
	//}
                
      
        
}