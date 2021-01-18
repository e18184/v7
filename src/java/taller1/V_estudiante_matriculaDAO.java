/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package taller1;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class V_estudiante_matriculaDAO {
	public static V_estudiante_matricula loadV_estudiante_matriculaByORMID(int ci) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return loadV_estudiante_matriculaByORMID(session, ci);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula getV_estudiante_matriculaByORMID(int ci) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return getV_estudiante_matriculaByORMID(session, ci);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByORMID(int ci, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return loadV_estudiante_matriculaByORMID(session, ci, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula getV_estudiante_matriculaByORMID(int ci, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return getV_estudiante_matriculaByORMID(session, ci, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByORMID(PersistentSession session, int ci) throws PersistentException {
		try {
			return (V_estudiante_matricula) session.load(taller1.V_estudiante_matricula.class, new Integer(ci));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula getV_estudiante_matriculaByORMID(PersistentSession session, int ci) throws PersistentException {
		try {
			return (V_estudiante_matricula) session.get(taller1.V_estudiante_matricula.class, new Integer(ci));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByORMID(PersistentSession session, int ci, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (V_estudiante_matricula) session.load(taller1.V_estudiante_matricula.class, new Integer(ci), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula getV_estudiante_matriculaByORMID(PersistentSession session, int ci, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (V_estudiante_matricula) session.get(taller1.V_estudiante_matricula.class, new Integer(ci), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryV_estudiante_matricula(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return queryV_estudiante_matricula(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryV_estudiante_matricula(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return queryV_estudiante_matricula(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula[] listV_estudiante_matriculaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return listV_estudiante_matriculaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula[] listV_estudiante_matriculaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return listV_estudiante_matriculaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryV_estudiante_matricula(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From taller1.V_estudiante_matricula as V_estudiante_matricula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryV_estudiante_matricula(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From taller1.V_estudiante_matricula as V_estudiante_matricula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("V_estudiante_matricula", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula[] listV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryV_estudiante_matricula(session, condition, orderBy);
			return (V_estudiante_matricula[]) list.toArray(new V_estudiante_matricula[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula[] listV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryV_estudiante_matricula(session, condition, orderBy, lockMode);
			return (V_estudiante_matricula[]) list.toArray(new V_estudiante_matricula[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return loadV_estudiante_matriculaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return loadV_estudiante_matriculaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		V_estudiante_matricula[] v_estudiante_matriculas = listV_estudiante_matriculaByQuery(session, condition, orderBy);
		if (v_estudiante_matriculas != null && v_estudiante_matriculas.length > 0)
			return v_estudiante_matriculas[0];
		else
			return null;
	}
	
	public static V_estudiante_matricula loadV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		V_estudiante_matricula[] v_estudiante_matriculas = listV_estudiante_matriculaByQuery(session, condition, orderBy, lockMode);
		if (v_estudiante_matriculas != null && v_estudiante_matriculas.length > 0)
			return v_estudiante_matriculas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateV_estudiante_matriculaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return iterateV_estudiante_matriculaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateV_estudiante_matriculaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = model.pojo.ProyectoPersistentManager.instance().getSession();
			return iterateV_estudiante_matriculaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From taller1.V_estudiante_matricula as V_estudiante_matricula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateV_estudiante_matriculaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From taller1.V_estudiante_matricula as V_estudiante_matricula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("V_estudiante_matricula", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(taller1.V_estudiante_matricula v_estudiante_matricula) throws PersistentException {
		try {
			model.pojo.ProyectoPersistentManager.instance().getSession().refresh(v_estudiante_matricula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(taller1.V_estudiante_matricula v_estudiante_matricula) throws PersistentException {
		try {
			model.pojo.ProyectoPersistentManager.instance().getSession().evict(v_estudiante_matricula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
