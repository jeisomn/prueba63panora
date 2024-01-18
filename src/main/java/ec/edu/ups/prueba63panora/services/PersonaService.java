package ec.edu.ups.prueba63panora.services;

import java.util.List;

import ec.edu.ups.prueba63panora.GestionDatos.GestionPersonas;
import ec.edu.ups.prueba63panora.model.Persona;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("persona")
public class PersonaService {
	
	@Inject
	private GestionPersonas gPersonas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Persona persona) {
		try{
			gPersonas.guradarPersona(persona);
			return Response.ok(persona).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try{
			gPersonas.borrar(codigo);
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer(@QueryParam("cedula") String cedula, @QueryParam("nombre") String nombre) {
		try{
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Persona cli = gPersonas.getPorCedula(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getPersonas(){
		List<Persona> clientes = gPersonas.getPersonas();
		if(clientes.size()>0)
			return Response.ok(clientes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}