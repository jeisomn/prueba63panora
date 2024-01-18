package ec.edu.ups.prueba63panora.personaDAO;

import java.util.List;

import ec.edu.ups.prueba63panora.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public Persona read(int codigo) {
		Persona per = em.find(Persona.class, codigo);
		return per;
	}
	
	public void remove(int codigo) {
		Persona auto = em.find(Persona.class, codigo);
		em.remove(auto);
	}
	
	public List<Persona> getAlll() {
		String jpql = "SELECT c FROM Persona c";
		Query q = em.createQuery(jpql, Persona.class);
		return q.getResultList();
	}
	
	public Persona getPorCedula(String cedula) {
		String jpql = "SELECT c FROM Persona c WHERE c.Cedula = :cedula";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter("cedula", cedula);
		List <Persona> personas =  q.getResultList();
		if(personas.size()>0)
			return personas.get(0);
		return null;
	}
	
	

}
