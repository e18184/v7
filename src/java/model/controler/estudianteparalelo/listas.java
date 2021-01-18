/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controler.estudianteparalelo;

import java.util.Iterator;
import java.util.List;
import model.pojo.Matricula;
import org.orm.PersistentException;
/**
 *
 * @author richards
 */
public class listas {
   /* public static void main(String args[]) throws PersistentException{
       int ci =2;
       List lista = model.pojo.MatriculaDAO.queryMatricula("estudianteci="+ci+" and fecha=(select max(fecha) "
               + "from Matricula where estudianteci="+ci +") ","estudianteci");
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Matricula b = (Matricula)it.next();
            System.out.println("est:"+b.getEstudiante().getCi()+" paralelo: "+b.getParalelo().getNombre()+"fecha:"+b.getFecha());  
        }
        
   }*/
public static void main(String args[]) throws PersistentException{ 
List lista = model.pojo.MatriculaDAO.queryMatricula("  SELECT DISTINCT ci,nombre, ap, am, max(nromatriculaciones) FROM "+ 
" ((select e.ci,e.nombre, e.ap, e.am,  count(m.estudianteci) as nromatriculaciones from " + 
" taller1.estudiante e, taller1.matricula m where e.ci = m.estudianteci "+
" group by ci) UNION ( SELECT e.ci, nombre,ap,am, 0 FROM TALLER1.estudiante e ) ) as TABLA " +
" group by ci,nombre,ap,am ", "ci,nombre,ap,am");      

for (Iterator it = lista.iterator(); it.hasNext();) {
            Matricula b = (Matricula)it.next();
            System.out.println("est:"+b.getEstudiante().getCi());  
        }
}
}