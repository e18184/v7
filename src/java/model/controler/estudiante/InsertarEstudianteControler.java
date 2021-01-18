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
import model.pojo.Estudiante;
import model.pojo.EstudianteDAO;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import model.pojo.*;
@Controller
@RequestMapping("insertarEstudiante.htm")
public class InsertarEstudianteControler {
    private EstudianteValidar estudianteValidar;
    public InsertarEstudianteControler(){
        this.estudianteValidar = new EstudianteValidar();
    }
            
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView insertarEstudiante()
    {  ModelAndView mav = new ModelAndView();
       mav.setViewName("insertarEstudiante");
       mav.addObject("datos", new Estudiante());
       //listadosuspendido();
       return mav;
    }
    
    // validamos los datos del formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView insertarEstudiante(
            @ModelAttribute("datos") Estudiante es,
            BindingResult result,
            SessionStatus status
    )
    {
     this.estudianteValidar.validate(es, result);
     if (result.hasErrors()) {
         ModelAndView mav = new ModelAndView();
         mav.setViewName("insertarEstudiante");
         return mav;
     } else 
        //System.out.println(es.getCi()+""+es.getRude()+" "+es.getNombre()+""+es.getAp()+""+es.getAm()+""+ es.getCorreo()+""+es.getUsuario()+
        //        ""+ es.getContrasena()+""+es.getSuspendido()+""+ es.getDireccion()+""+es.getImagen());
     
        try {
        //PersistentTransaction t = model.pojo.ProyectoPersistentManager.instance().getSession().beginTransaction();
	//model.pojo.estudiante estud = model.pojo.estudianteDAO.createEstudiante();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : matriculas, rude
			
                         //       ;mbre,ap,am,correo,telefono,usuario, contrasena,suspendido,direccion,imagen)
            // values ("+per.getCi+"",) 
            es.setCi(es.getCi());
         es.setRude(es.getRude());
         es.setNombre(es.getNombre());
         es.setAp(es.getAp());
         es.setAm(es.getAm());
         es.setCorreo(es.getCorreo());
         es.setTelefono(es.getTelefono());
         es.setUsuario(es.getUsuario());
         es.setContrasena(es.getContrasena());
         es.setSuspendido(es.getSuspendido());
         es.setDireccion(es.getDireccion());
         es.setImagen(es.getImagen());
         es.setEstado(true);
         model.pojo.EstudianteDAO.save(es);
         //t.commit();
        } catch (PersistentException ex) {
            Logger.getLogger(InsertarEstudianteControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:listaEstudiantes.htm");
    }
     @ModelAttribute("suspendidos")
        public Map<String,String> listadosuspendido()
        {
            Map <String,String> listado = new LinkedHashMap<>();
            listado.put("1","Suspendido");
            listado.put("2","No suspendido");
            return listado;
        }

	/**
	 * 
	 * @param per
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String insertarEstudiante(Estudiante per, ModelMap model) {
		// TODO - implement InsertarEstudianteControler.insertarEstudiante
		throw new UnsupportedOperationException();
	}

}