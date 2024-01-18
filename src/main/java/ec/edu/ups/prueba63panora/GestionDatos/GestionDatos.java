package ec.edu.ups.prueba63panora.GestionDatos;

import ec.edu.ups.prueba63panora.model.Persona;
import ec.edu.ups.prueba63panora.personaDAO.PersonaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private PersonaDAO daoPersona;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");
		
		Persona per = new Persona();
		per.setCodigo(1);
		per.setCedula("0303128672");
		per.setNombre("Juan Vazquez");
		per.setMes("Enero");
		per.setCantidad(34.50);
		
		
		
		daoPersona.insert(per);
		
		System.out.println("Persona" + per);
	}
}
