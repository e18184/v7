/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.profesor;
import model.controler.estudiante.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.pojo.Estudiante;
import model.pojo.EstudianteDAO;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class Insertar {
    public static void main(String args[]) throws PersistentException {
       //PersistentTransaction t = model.pojo.ProyectoPersistentManager.instance().getSession().beginTransaction();
	model.pojo.Estudiante estud = model.pojo.EstudianteDAO.createEstudiante();
        //model.pojo.estudiante estud = null; 
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : matriculas, rude
			
                         //       ;mbre,ap,am,correo,telefono,usuario, contrasena,suspendido,direccion,imagen)
            // values ("+per.getCi+"",) 
        try {

        estud.setCi(4143805);
         estud.setRude(4143);
         estud.setNombre("Alejandro");
         estud.setAp("Sivila");
         estud.setAm("Moreno");
         estud.setCorreo("e18184@gmail.com");
         estud.setTelefono("59160257836");
         estud.setUsuario("123");
         estud.setContrasena("123");
         estud.setSuspendido(1);
         estud.setDireccion("B. Aeropuerto");
         estud.setImagen("");
         model.pojo.EstudianteDAO.save(estud);
         //session.flush();
        // t.commit();
         
        }
          catch (PersistentException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
         
}
    }
