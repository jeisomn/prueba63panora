package ec.edu.ups.prueba63panora.GestionDatos;

import java.util.List;
import ec.edu.ups.prueba63panora.model.Persona;
import ec.edu.ups.prueba63panora.personaDAO.PersonaDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionPersonas {
	
	@Inject
	private PersonaDAO daoPersona;
	
	public void guradarPersona(Persona persona) {
		Persona per = daoPersona.read(persona.getCodigo());
		daoPersona.insert(persona);
	}
	
	public List<Persona> getPersonas(){
		return daoPersona.getAlll();
	}
	
	public Persona getPorCedula(String cedula) throws Exception {
		if(cedula.length()!=10)
			throw new Exception("Cedula Incorrecta");
		return daoPersona.getPorCedula(cedula);
	}
	
	public void borrar(int codigo) {
		daoPersona.remove(codigo);
	}

}
