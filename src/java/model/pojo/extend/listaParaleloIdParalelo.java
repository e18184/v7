package model.pojo.extend;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.orm.*;
import model.pojo.Asigna;
import model.pojo.Paralelo;
import org.hibernate.Session;
public class listaParaleloIdParalelo{
private model.pojo.Paralelo paralelo;   

    public static  Asigna obtenAsignacionIdParaleloDAO(model.pojo.Paralelo paralelo) throws PersistentException
    {   
        try {
        Query query = null;
        PersistentSession sesion = model.pojo.ProyectoPersistentManager.instance().getSession();
        //query = sesion.createQuery("FROM Asigna where CAST(anno,integer)=2017"); 
        /*String consulta = "select MAX(a.anno) from Asigna as a, Paralelo p" +
                " where a.getParalelo().getIdparalelo()= p.idparalelo AND p.idparalelo=:parametro1";
        String consulta2 = "select MAX(a.anno) from Asigna as "
                + " a left join a.Paralelo as paralelo where paralelo.idparalelo=:parametro1";
        
        String consulta3 = "select MAX(a.anno) from Asigna as a "+
                " where a.getParalelo().getIdparalelo()=:parametro1";
        */
        String consulta4 = "from Asigna a where a.anno = (select MAX(a.anno) from Asigna as a  LEFT JOIN a.ORM_Paralelo p where p.idparalelo=:parametro1)";
        
        query = sesion.createQuery(consulta4);
        query.setString("parametro1",paralelo.getIdparalelo());
        //"(select MAX(a.anno) from Asigna as a where a.paraleloId=:paralelo)");
       
        //query.setString("paralelo","1A");
        
        
         return (Asigna)query.list().get(0);
        }
        catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}

        
    }
    public static Asigna update (Asigna tipo) {
        try {
        PersistentSession sesion = model.pojo.ProyectoPersistentManager.instance().getSession();
            
        
             Query query = null;
            String consulta = "update :clase set horaentrada:phoraentrada, horasalida=:phorasalida , anno:panno, ORM_Paralelo=:pparalelo, ORM_Aula=:paula where "+
                    "horaentrada:phoraentrada AND horasalida:phorasalida AND ORM_Paralelo=:pparalelo AND ORM_Aula=:paula";
            query = sesion.createQuery(consulta);
            System.out.println();
            query.setParameter("clase",tipo);
            query.setParameter("phoraentrada",tipo.getHoraentrada());
            query.setParameter("phorasalida",tipo.getHorasalida());
            query.setParameter("panno",tipo.getAnno());
            query.setParameter("pparalelo",tipo.getParalelo().getIdparalelo());
            query.setParameter("paula",tipo.getAula().getIdaula());
            query.executeUpdate();
            
        } catch (PersistentException ex) {
            Logger.getLogger(listaParaleloIdParalelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo;
    }
    
    
    public static void main(String[] args) throws PersistentException 
    {
         Paralelo paralelo = new Paralelo();
         paralelo.setIdparalelo("1A");
         Asigna a = obtenAsignacionIdParaleloDAO(paralelo);
         System.out.println(a.getAulaId()+" "+ a.getHoraentrada()+ " "+ a.getHorasalida()+ " "+ a.getParalelo().getIdparalelo()+" "+ a.getParalelo().getIdparalelo());
        /*List<Asigna> listaResultados = obtenAsignacionIdParaleloDAO(paralelo);

        for (int i = 0; i < listaResultados.size(); i++)
        {
            System.out.println("Nombre " + i + ": " + listaResultados.get(i));
        }*/
         

        
    }
    
}