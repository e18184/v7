/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudianteparalelo;
import java.text.ParseException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Matricula;
import model.pojo.Paralelo;
import model.pojo.Estudiante;
import model.pojo.EstudianteDAO;
import org.orm.PersistentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("matricularestudiante.htm")
public class MatricularEstudianteParaleloControler1 {
    private int ci;
    private void setCi(int pci) {
        this.ci = pci;
    };
    private int getCi() {
        return this.ci;
    }
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView matricularestudiante(HttpServletRequest request) throws ParseException
    {   //try {
        ModelAndView mav = new ModelAndView();
        int pci = Integer.parseInt(request.getParameter("ci"));
        
        
        this.setCi(pci);
        mav.setViewName("matricularestudiante");
        Matricula ma = new Matricula();
        // nuevo
        //System.out.println("Entro aqui2:"+pci );
        //ma = getMatriculaByORMID(fecha, pa, est);
        //ma = getMatriculaByORMID(fecha, paralelo, estudiante)
        mav.addObject("matricula", ma);
        
        //listadosuspendido();
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
	public org.springframework.web.servlet.ModelAndView matricularestudiante(HttpServletRequest request, @ModelAttribute("matricula")
	Matricula ma) {
            System.out.println("Entro aqui");
            System.out.println("ci:"+ma.getEstudianteId()+" "+
                    "  paralelo:"+ma.getParalelo().getIdparalelo()+ "  fecha:"+ma.getFecha());
          /* estudiante est = new estudiante();
           est.setCi(4);
           paralelo  pa = new paralelo();
           pa.setIdparalelo("2B");
           
           // grabar 
           ma.setEstudiante(est);
           ma.setParalelo(pa);
           ma.setFecha(ma.getFecha());*/
           /* ma.setEstudianteId(this.getCi());
            ma.setParaleloId(ma.getParaleloId());
            ma.setFecha(ma.getFecha());
            */
        /*try {
            matriculaDAO.save(ma);
        } catch (PersistentException ex) {
            Logger.getLogger(MatricularEstudianteParaleloControler.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
        @ModelAttribute("estudianteId")
        public Estudiante lestudianteci(@RequestParam("ci") int cip) {
       
            
            
            System.out.println("valor de ci:"+cip);
            
            
            Matricula mat  = new Matricula();
            Estudiante es = new Estudiante();
            es.setCi(cip);
            mat.setEstudiante(es);
            
      
            
            return mat.getEstudiante();
        }
        
        
      
        
}