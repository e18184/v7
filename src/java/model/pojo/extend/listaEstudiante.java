package model.pojo.extend;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.orm.*;
import model.pojo.Asigna;
import model.pojo.Estudiante;
import model.pojo.Paralelo;
import org.hibernate.Session;
public class listaEstudiante{
private model.pojo.Paralelo paralelo;   
private model.pojo.Estudiante estudiante;

    public static  List listarEstudianteDAO() throws PersistentException
    {   
        try {
        Query query = null;
        PersistentSession sesion = model.pojo.ProyectoPersistentManager.instance().getSession();
        String consulta4 = "from Estudiante a where a.estado=TRUE";
        
        query = sesion.createQuery(consulta4);
         return query.list();
        }
        catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}

        
    }
    public static void main(String[] args) throws PersistentException 
    {
      
         List<Estudiante> estudiante =  (List<Estudiante>)listarEstudianteDAO();
         //System.out.println(a.getAulaId()+" "+ a.getHoraentrada()+ " "+ a.getHorasalida()+ " "+ a.getParaleloId()+" "+ a.getParalelo().getIdparalelo());
        /*List<Asigna> listaResultados = obtenAsignacionIdParaleloDAO(paralelo);*/

        for (int i = 0; i < estudiante.size(); i++)
        {
            Estudiante est = estudiante.get(i);
            System.out.println("Nombre " + i + ": " + est.getNombre());
        }
         

        
    }
    
}